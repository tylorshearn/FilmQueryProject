package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private Integer iD;
	private String title;
	private String description;
	private Integer releaseYear;
	private Integer languageId;
	private String language;
	private Integer rentalDuration;
	private Integer length;
	private Double replacementCost;
	private Double rentalRate;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;

	public Film() {
		super();
	}
	
	public Film(Integer iD, String title, String description, Integer releaseYear, Integer languageId, String language,
			Integer rentalDuration, Integer length, Double replacementCost, Double rentalRate, String rating,
			String specialFeatures) {
		super();
		this.iD = iD;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rentalRate = rentalRate;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}
	
	public Film(Integer iD, String title, String description, Integer releaseYear, Integer languageId,
			Integer rentalDuration, Integer length, Double replacementCost, Double rentalRate, String rating,
			String specialFeatures) {
		super();
		this.iD = iD;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rentalRate = rentalRate;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}


	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((iD == null) ? 0 : iD.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((rentalDuration == null) ? 0 : rentalDuration.hashCode());
		result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result + ((replacementCost == null) ? 0 : replacementCost.hashCode());
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (iD == null) {
			if (other.iD != null)
				return false;
		} else if (!iD.equals(other.iD))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration == null) {
			if (other.rentalDuration != null)
				return false;
		} else if (!rentalDuration.equals(other.rentalDuration))
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (replacementCost == null) {
			if (other.replacementCost != null)
				return false;
		} else if (!replacementCost.equals(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [iD=").append(iD).append(", title=").append(title).append(", description=")
				.append(description).append(", releaseYear=").append(releaseYear).append(", languageId=")
				.append(languageId).append(", language=").append(language).append(", rentalDuration=")
				.append(rentalDuration).append(", length=").append(length).append(", replacementCost=")
				.append(replacementCost).append(", rentalRate=").append(rentalRate).append(", rating=").append(rating)
				.append(", specialFeatures=").append(specialFeatures);
		return builder.toString();
	}
	
	public String toStringLimited() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title : ").append(title).append("|| Release Year : ").append(releaseYear).append("|| Rating : ").append(rating).append("|| Description : ").append(description).append("|| Language : ").append(language).append("|| Actors : ").append(actors);
		return builder.toString();
	}

	
	
}
	
	

