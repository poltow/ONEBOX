package com.railroad.commuter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	RailroadCommuterFeature.class,
	RailroadCommuterTest.class, 
	RailroadNetworkTest.class })
public class AllTests {

}
