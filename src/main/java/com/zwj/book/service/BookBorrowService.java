package com.zwj.book.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwj.book.base.BizException;
import com.zwj.book.dao.BookBorrowMapper;
import com.zwj.book.dao.BookMapper;
import com.zwj.book.entity.Book;
import com.zwj.book.entity.BookBorrowDisInfo;
import com.zwj.book.entity.BookBorrowInfo;

@Service
public class BookBorrowService {
	@Autowired
	public BookBorrowMapper bookBorrowkMapper;

	@Autowired
	public BookMapper bookkMapper;

	public List<BookBorrowDisInfo> getAllBookBorrowInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookBorrowInfo> infos = bookBorrowkMapper.getBookBorrowInfos(map);
		return edit(infos);
	}

	private List<BookBorrowDisInfo> edit(List<BookBorrowInfo> infos) {
		List<BookBorrowDisInfo> infoList = new ArrayList<BookBorrowDisInfo>();
		infos.stream().forEach(info -> {
			BookBorrowDisInfo disInfo = new BookBorrowDisInfo();
			disInfo.setBorrowTime(info.getBorrowTime() + "天");
			disInfo.setBookName(info.getBookName());
			disInfo.setUserName(info.getUserName());
			SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if (info.getBorrowDate() != null) {
				disInfo.setBorrowDate(sdfDateFormat.format(info.getBorrowDate()));
			}
			if (info.getReturnDate() != null) {
				disInfo.setReturnDate(sdfDateFormat.format(info.getReturnDate()));
			}
			infoList.add(disInfo);

		});
		return infoList;
	}

	public List<BookBorrowDisInfo> getBorrowInfosByUserId(String userId) {
		List<BookBorrowInfo> infos = bookBorrowkMapper.getBorrowInfosByUserId(userId);
		return edit(infos);

	}

	@Transactional
	public void insertBookBorrowInfo(BookBorrowInfo info) {
		Date nowDate = new java.util.Date();
		info.setBorrowDate(nowDate);
		int cnt = bookBorrowkMapper.checkBookBorrrow(info);
		if (cnt == 1) {
			throw new BizException("该图书已经在借阅中");
		}
		bookBorrowkMapper.insertBookBorrowInfo(info);
		Book currentBook = bookkMapper.findById(String.valueOf(info.getBookId()));
		currentBook.setStock(currentBook.getStock() - 1);
		bookkMapper.updateBook(currentBook);

	}

	@Transactional
	public void updateBookBorrowInfo(BookBorrowInfo info) {
		Date nowDate = new java.util.Date();
		info.setReturnDate(nowDate);
		bookBorrowkMapper.updateBookBorrowInfo(info);
		Book currentBook = bookkMapper.findById(String.valueOf(info.getBookId()));
		currentBook.setStock(currentBook.getStock() + 1);
		bookkMapper.updateBook(currentBook);
	}
}
