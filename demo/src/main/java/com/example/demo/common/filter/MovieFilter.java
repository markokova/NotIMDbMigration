package com.example.demo.common.filter;

import java.util.UUID;

public class MovieFilter {
	public int Runtime;
    public UUID UserId;
    public String FilterString;
    public UUID GenreId;
    public boolean ShouldFilterById;
    public boolean IsWatched;
    
	 public int getRuntime() {
		return Runtime;
	}
	public void setRuntime(int runtime) {
		Runtime = runtime;
	}
	public UUID getUserId() {
		return UserId;
	}
	public void setUserId(UUID userId) {
		UserId = userId;
	}
	public String getFilterString() {
		return FilterString;
	}
	public void setFilterString(String filterString) {
		FilterString = filterString;
	}
	public UUID getGenreId() {
		return GenreId;
	}
	public void setGenreId(UUID genreId) {
		GenreId = genreId;
	}
	public boolean isShouldFilterById() {
		return ShouldFilterById;
	}
	public void setShouldFilterById(boolean shouldFilterById) {
		ShouldFilterById = shouldFilterById;
	}
	public boolean isIsWatched() {
		return IsWatched;
	}
	public void setIsWatched(boolean isWatched) {
		IsWatched = isWatched;
	}
}
