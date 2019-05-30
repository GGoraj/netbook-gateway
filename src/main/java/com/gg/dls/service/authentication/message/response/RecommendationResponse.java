package com.gg.dls.service.authentication.message.response;

import java.util.List;
import com.gg.dls.service.authentication.model.Book;

public class RecommendationResponse {
	// TODO: Make this class match the properties of the object returned by the
	// Recommendation Service.
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
