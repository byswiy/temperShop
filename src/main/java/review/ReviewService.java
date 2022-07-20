package review;

import dao.ReviewInfoDao;
import vo.ReviewInfo;

public class ReviewService {
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
