package sqlitePackage;

public class Citations_Docu_WebPage {

String authorLName;
String authorInitials;
String datePublication;
String title;
String urlWebAddress;
public String getAuthorLName() {
	return authorLName;
}
public void setAuthorLName(String authorLName) {
	this.authorLName = authorLName;
}
public String getAuthorInitials() {
	return authorInitials;
}
public void setAuthorInitials(String authorInitials) {
	this.authorInitials = authorInitials;
}
public String getDatePublication() {
	return datePublication;
}
public void setDatePublication(String datePublication) {
	this.datePublication = datePublication;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getUrlWebAddress() {
	return urlWebAddress;
}
public void setUrlWebAddress(String urlWebAddress) {
	this.urlWebAddress = urlWebAddress;
}

public String toString() {
	//return "[" + idNum + "] - " + name + ": " + year + " " + newText;
//	return authorLName + " " + authorInitials + " (" + year + ") "
	//		+ title + ". Retrieved from: " + url + ".";  
	return authorLName + " " + authorInitials + " (" + datePublication + "). " + title + ". Retrieved From: " + urlWebAddress;  
	
	}

}
