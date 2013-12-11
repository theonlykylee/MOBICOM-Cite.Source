package sqlitePackage;

public class DatabaseCitations {

	String sourceType;
	String projectName;
	String dateCreated;
	String sourceTitle;
	String citation;
	
	

public String getSourceType() {
		return sourceType;
	}



	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}



	public String getSourceTitle() {
		return sourceTitle;
	}



	public void setSourceTitle(String sourceTitle) {
		this.sourceTitle = sourceTitle;
	}



	public String getCitation() {
		return citation;
	}



	public void setCitation(String citation) {
		this.citation = citation;
	}



public String toString() {
	//return "[" + idNum + "] - " + name + ": " + year + " " + newText;
//	return authorLName + " " + authorInitials + " (" + year + ") "
	//		+ title + ". Retrieved from: " + url + ".";  
	//return authorLName + " " + authorInitials + " (" + datePublication + "). " + title + ". Retrieved From: " + urlWebAddress;  
	return "tite";
	}

}
