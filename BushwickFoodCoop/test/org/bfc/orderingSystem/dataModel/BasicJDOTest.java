package org.bfc.orderingSystem.dataModel;


import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class BasicJDOTest {

    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	
	@Before
	public void setUp() throws Exception {
		helper.setUp();
	}

	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	@Test
	public void testPersistNewInventoryObjects(){
		
		
		InventoryItem butter = new InventoryItem("Butter", "Dairy", 12.50, 10.0, false);
		InventoryItem cheese = new InventoryItem("Cheese", "Dairy", 14.20, 11.0, false);
		InventoryItem chicken = new InventoryItem("Chicken", "Meat", 10.0, 9.0, false);
		
        PersistenceManager pm = PMF.get().getPersistenceManager();
        //Transaction tx = pm.currentTransaction();
        try {
         //   tx.begin();

            pm.makePersistentAll(butter, cheese, chicken);
            
          //  tx.commit();
        } catch(Exception e){
        	e.printStackTrace();
        	Assert.fail(e.getMessage());
        }finally {
            /*if (tx.isActive()) {
                tx.rollback();
            }*/
            pm.close();
        }
		
	}
}
