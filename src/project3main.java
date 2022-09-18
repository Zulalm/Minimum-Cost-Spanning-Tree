import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class project3main {

	public static void main(String[] args) throws FileNotFoundException {
		boolean marry = false;
		HashMap<String,PriorityQueue<Edge>> firstPart = new HashMap<String,PriorityQueue<Edge>>();
		PriorityQueue<Edge> secondPart = new PriorityQueue<Edge>();
		HashSet<String> allSets = new HashSet<String>();
		HashMap<String,HashSet<String>> checkVisited = new HashMap<String,HashSet<String>>();
		//data taking
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		int timeLimit = in.nextInt();
		int noCities = in.nextInt();
		String line = in.nextLine();
		while (line.isEmpty()) {
			line = in.nextLine();
		}
		String mecnunsCity = line.split(" ")[0];
		String leylasCity = line.split(" ")[1];
		line = in.nextLine();
		while (line.isEmpty()) {
			line = in.nextLine();
		}
		while(!line.split(" ")[0].equals(leylasCity)) {
			while (line.split(" ").length ==0) {
				line = in.nextLine();
				continue;
			}
			String[] edgeList = line.split(" ");
			firstPart.put(edgeList[0], new PriorityQueue<Edge>());
			for(int i = 1; i<edgeList.length;i+=2) {
				firstPart.get(edgeList[0]).add(new Edge(edgeList[0],edgeList[i],Integer.parseInt(edgeList[i+1])));
			}
			line = in.nextLine();
		}
		int hMcities = noCities - firstPart.size();
		for(int j=0;j<hMcities;j++) {
			while (line.isEmpty()) {
				line = in.nextLine();
				continue;
			}
			String[] edgeList = line.split(" ");
			HashSet<String> set = new HashSet<String>();
			set.add(edgeList[0]);
			allSets.add(edgeList[0]);
			checkVisited.put(edgeList[0],set);
			for(int i = 1; i<edgeList.length;i+=2) {
				secondPart.add(new Edge(edgeList[0],edgeList[i],Integer.parseInt(edgeList[i+1])));

			}
			if(in.hasNext()) {
				line = in.nextLine();
			}
		}
		//end of data taking
		
		HashMap<String,Integer> visited = new HashMap<String,Integer>();
		int minDistance = Integer.MAX_VALUE;
		int minCost = 0;

		PriorityQueue<Location> queue = new PriorityQueue<Location>();
		queue.add(new Location(mecnunsCity,0,mecnunsCity));
		String path = "";
		while(!queue.isEmpty()) {
			Location location = queue.poll();
			if(location.getCity().equals(leylasCity)) {
				if(location.getDistanceFromRoot()<minDistance) {
					path = location.getPath();
					minDistance = location.getDistanceFromRoot();
				}
				continue;
			}
			while(!firstPart.get(location.getCity()).isEmpty()) {
				Edge edge = firstPart.get(location.getCity()).poll();
				if(!visited.containsKey(edge.getCity2())) {
					if (!location.getIncluded().contains(edge.getCity2())) {
						String newPath = location.getPath()+" "+ edge.getCity2();
						visited.put(edge.getCity2(),location.getDistanceFromRoot()+edge.getDistance());
						queue.add(new Location(edge.getCity2(),location.getDistanceFromRoot()+edge.getDistance(),newPath));

					}}
				else if (visited.get(edge.getCity2())>location.getDistanceFromRoot()+edge.getDistance()) {
					if (!location.getPath().contains(edge.getCity2())) {				
						String newPath = location.getPath()+" "+ edge.getCity2();
						visited.put(edge.getCity2(),location.getDistanceFromRoot()+edge.getDistance());
						queue.add(new Location(edge.getCity2(),location.getDistanceFromRoot()+edge.getDistance(),newPath));
					}}
			}}
		if(path.equals("")) {
			out.println(-1);
		}
		else {
		out.println(path);
		}
		if(minDistance<= timeLimit) {
			marry = true;
		}

		if(marry) {
			while(allSets.size()!=1 && !secondPart.isEmpty()) {
				Edge edge = secondPart.poll();
				if(!checkVisited.get(edge.getCity1()).contains(edge.getCity2())) {
					HashSet<String> set1 = checkVisited.get(edge.getCity1());
					HashSet<String> set2 = checkVisited.get(edge.getCity2());
					set1.addAll(set2);
					
					for(String city:set2) {
						checkVisited.put(city, set1);
						allSets.remove(city);
					}
					minCost+=edge.getDistance();

				}
				

			}
			
			if(allSets.size()==1) {
				out.print(minCost*2);}
			else {
				out.print(-2);
			}
		}
		else {
			out.print(-1);
		}

	}

}
