package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("favoriteID")
public class FavoriteBean {
	private int favoriteID;
	private int userID;
	private String url;
	private String comment;
	private int clickCount;
	public int getFavoriteID() {
		return favoriteID;
	}
	public void setFavoriteID(int favoriteID) {
		this.favoriteID = favoriteID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	
}
