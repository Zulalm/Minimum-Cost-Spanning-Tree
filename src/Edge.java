
public class Edge implements Comparable<Edge>{
	private String city1;
	private String city2;
	private int distance;
	private String edgeName;
	public Edge(String city1,String city2,int distance) {
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
		if(city1.compareTo(city2)<0) {
			this.edgeName = city1+" "+city2;
		}
		else {
			this.edgeName = city2+" "+city1;
		}
	}
	
	/**
	 * @return the city1
	 */
	public String getCity1() {
		return city1;
	}
	/**
	 * @param city1 the city1 to set
	 */
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	/**
	 * @return the city2
	 */
	public String getCity2() {
		return city2;
	}
	/**
	 * @param city2 the city2 to set
	 */
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.distance < o.distance){
			return -1;
		}
		else if(this.distance>o.distance) {
			return 1;
		}
		else if(this.city2.compareTo(o.city2)<0) {
			return -1;
		}
		else {
			return 1;
		}
	
	}
	/**
	 * @return the edgeName
	 */
	public String getEdgeName() {
		return edgeName;
	}
	/**
	 * @param edgeName the edgeName to set
	 */
	public void setEdgeName(String edgeName) {
		this.edgeName = edgeName;
	}
}
