import java.util.HashSet;


public class Location implements Comparable<Location>{
	private String city;
	private int distanceFromRoot;
	private HashSet<String> included = new HashSet<String>();
	private String path;
	public Location(String city,int distanceFromRoot,String path) {
		this.setCity(city);
		this.setDistanceFromRoot(distanceFromRoot);
		this.path = path;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the distanceFromRoot
	 */
	public int getDistanceFromRoot() {
		return distanceFromRoot;
	}
	/**
	 * @param distanceFromRoot the distanceFromRoot to set
	 */
	public void setDistanceFromRoot(int distanceFromRoot) {
		this.distanceFromRoot = distanceFromRoot;
	}
	@Override
	public int compareTo(Location o) {
		if(this.distanceFromRoot<o.distanceFromRoot) {
			return-1;
			
		}
		else if(this.distanceFromRoot>o.distanceFromRoot) {
			return 1;
		}
		else if(this.city.compareTo(o.city)<0) {
			return -1;
		}
		else {
			return 1;
		}
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the included
	 */
	public HashSet<String> getIncluded() {
		return included;
	}
	/**
	 * @param included the included to set
	 */
	public void setIncluded(HashSet<String> included) {
		this.included = included;
	}
	
	
}
