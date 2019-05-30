package com.gg.dls.service.authentication.message.response;

import java.util.List;
import com.gg.dls.service.authentication.model.Book;

/**
 * The properties of this class should match that of the JSON-object received
 * from the recommendation service.
 * 
 * @author PC-EKY
 *
 */
public class RecommendationResponse {

	private List<Book> recommendedBooks;

	public RecommendationResponse() {

	}

	public RecommendationResponse(List<Book> recommendedBooks) {
		this.recommendedBooks = recommendedBooks;
	}

	public List<Book> getRecommendedBooks() {
		return recommendedBooks;
	}

	public void setRecommendedBooks(List<Book> recommendedBooks) {
		this.recommendedBooks = recommendedBooks;
	}

}
