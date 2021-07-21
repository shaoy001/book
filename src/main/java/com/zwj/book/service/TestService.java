package com.zwj.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwj.book.dao.TestImgMapper;

@Service
public class TestService {
	@Autowired
	public TestImgMapper testImgMapper;

//	@Transactional // 因为没有加这个注解，报错ORA-22990
//	public void insertCover(MultipartFile image, TestImg testImg, String imagePath) {
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		int insertFlag = testImgMapper.insertTestImg(testImg);
//		if (insertFlag > 0) {
//			try {
//				TestImg currImg = testImgMapper.queryTestImg(testImg.getId());
//				// BookCover中的bookCover设置为Object对象，最开始设置为String,报java.lang.NullPointerException
//				Blob blob = (Blob) currImg.getImageObject();
//				byte[] data = null;
//				// 要保存到数据库的文件
//				inputStream = new FileInputStream(imagePath);
//				// book_cover作为接收输入文件流的对象
//				outputStream = blob.setBinaryStream(0);
//				data = FileCopyUtils.copyToByteArray(inputStream);
//				outputStream.write(data);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					outputStream.flush();
//					outputStream.close();
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
