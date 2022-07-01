package review;

import java.time.LocalDateTime;
import java.util.List;

import dao.MemberInfoDao;
import dao.ProductInfoDao;
import dao.ReviewInfoDao;
import vo.MemberInfo;
import vo.ProductInfo;
import vo.ReviewInfo;

public class ReviewService {
	public String loadReviewInfo(int pageNumber) {
		// 후기에 관한 정보를 불러온다
		ReviewInfoDao dao = new ReviewInfoDao();
		List<ReviewInfo> reviewInfoList = dao.selectReviewInfo(pageNumber);
		
		int member_userIdx = 0;
		int product_prodIdx = 0;
		
		for(ReviewInfo reviewInfo : reviewInfoList) {
			member_userIdx = reviewInfo.getMember_userIdx();
			product_prodIdx = reviewInfo.getProduct_prodIdx();
		}
		
		MemberInfo memberInfo = new MemberInfo();
		MemberInfoDao memberDao = new MemberInfoDao();
		memberInfo = memberDao.selectByUserIdx(member_userIdx);
		
		ProductInfo productInfo = new ProductInfo();
		ProductInfoDao prodDao = new ProductInfoDao();
		productInfo = prodDao.selectProductIdx(product_prodIdx);
		
		int amount = dao.getAmountReview();
		
		String data = "{\"amount\": " + amount + ",";
		data += "\"reviewInfoList\":[";
		for(ReviewInfo reviewInfo : reviewInfoList) {
			String id = memberInfo.getId();
			String prodSize = productInfo.getProdSize();
			String prodColor = productInfo.getProdColor();
			String contents = reviewInfo.getContents();
			LocalDateTime insertDate = reviewInfo.getInsertDate();
			
			// 공지사항의 내용을 작성할 때 엔터를 치면 엔터가 \r\n 으로 변환되서 저장됨
			// 이때 이 \ 때문에 자바스크립트가 전달 받은 공지사항 목록을 JSON으로 변환할 수 없게 됨
//			contents = contents.replace("\\", "\\\\");
			
			data = data + "{\"id\":\"" + id + "\",\"prodSize\":\"" + prodSize + "\",\"prodColor\":\"" + prodColor +
					      "\",\"contents\":\"" + contents + "\",\"insertDate\":\"" + insertDate + "\"},";
		}
		data = data.substring(0, data.length()-1);
		data = data + "]}";
		
		return data;
	}
	
	public boolean addReview(ReviewInfo reviewInfo) {
		ReviewInfoDao dao = new ReviewInfoDao();
		boolean result = dao.insertReview(reviewInfo);
		
		return result;
	}
	
	public boolean deleteReview(int reviewIdx) {
		ReviewInfoDao dao = new ReviewInfoDao();
		boolean result = dao.deleteReviewByReviewIdx(reviewIdx);
		
		return result;
	}
	
}
