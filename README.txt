Model rules
	The Railroad Commuter calculates the total distance for a path between 2 or more connected Towns from the railroad network.
	The Railroad Network is a set of Towns connected by Routes.
	A Town is represented by a graph Node.
	A Route is represented by a graph Edge.
	The railroad network is represented by a directed graph of Nodes and Edges.
	Each Route has a distance represented by the Edge weighting.
	The distance value cannot be zero or negative.
	A Town can have multiple outgoing Routes to other Towns.
	A Town can have multiple incoming Routes from other Towns.
	A Town CANNOT have a Route to itself.
	A possible path WILL NOT contains repeated Routes.
	A Town is identified by its name. The name can be any capital letter [A-Z].
	A Route is identified by its name. 
	The name of a Route consists of two capital letters. Origin town + Target town. 
	A route between two towns (from A to B) with a distance of 5 is represented as AB5. 


Acceptance criteria
	The desired Route is represented by a dash separated Town names, for example: A-B, D-C-E. 
	If there is no possible path between the Towns the output should be 'NO SUCH ROUTE'.
	A path between two Towns must be direct (no Town stops are allowed).
	
	For the test input, the towns are named using the first few letters of the
	alphabet from A to D.
	
	Graph: 
	AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	
	1. The distance of the route A-B-C. 
	2. The distance of the route A-D. 
	3. The distance of the route A-D-C. 
	4. The distance of the route A-E-B-C-D. 
	5. The distance of the route A-E-D.
	
	Output #1: 9 
	Output #2: 5 
	Output #3: 13 
	Output #4: 22 
	Output #5: NO SUCH ROUTE



How to test
-----------


Execute RailroadCommuterFeature for testing acceptance criteria

Execute RailroadCommuterTest for testing Railroad Commuter logic
	
Execute RailroadNetworkTest for testing Railroad Network model

Execute AllTest suite for running all the test 

How to run
----------

1) Create a RailroadNetwork

2) Add Routes to the RailroadNetwork by calling the method addInterTownRoute(String). 
The input format should be like AB1 where A is the name of the origin town, 
B is the name of the destination town and 1 is the distance of the route.

3) Create a RailroadCommuter passing the RailroadNetwork as an attribute

4) Consume the RailroadCommuter method calculatePathDistanceFor(String) for calculating path distances.
The input format should be like A-B-C where A, B, C are the names of the path's towns separated by dashes.
