package com.foodbook.foodbook.test;

import java.util.ArrayList;

import com.foodbook.foodbook.EditRecipeActivity;
import com.foodbook.foodbook.Recipe;

import android.test.ActivityInstrumentationTestCase2;


/**
 * <p> This class is testing the retrieval of local recipes made
 * test retrieve local
 * test create and save recipe
 * test edit recipe
 *  </p>
 * @author Jaeseo Park (jaeseo1), Jasmine Woo (jwoo), Nhu Bui (nbui), Robert Janes (rjanes)
 *
 */

public class localRecipeBookValidation extends ActivityInstrumentationTestCase2 {

	public localRecipeBookValidation() {
		super("com.foodbook.foodbook.test",EditRecipeActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EditRecipeActivity EditRecipeActivity = (com.foodbook.foodbook.EditRecipeActivity) getActivity(); 
	}
	
	private static final String INGRED_TITLE = "T I T L E";
    private static final String INGRED_DSCRIPTION = "A SPACE D E S C R I P T I O N";
    private static final String INGRED_INGREDIENT = "S U G A R";
    private static final String INGRED_INSTRUCTION = "M I X SPACE I T";
    
	public void testNewRecipe() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(INGRED_TITLE, INGRED_DSCRIPTION, INGRED_INSTRUCTION, ingred , category, "userid","username");
        // we use sendKeys instead of setText so it goes through entry
        // click on add tab
    	sendKeys(INGRED_TITLE);
    	sendKeys("TAB");
    	sendKeys(INGRED_DSCRIPTION);
    	//add ingredient
       // sendKeys(INGRED_TEA);
        //click on save tab
        sendKeys("TAB");
    	sendKeys(INGRED_INGREDIENT);
    	sendKeys("TAB");
    	sendKeys(INGRED_INSTRUCTION);
    	sendKeys("TAB");
    	sendKeys("ENTER");

        // get result

        assertTrue(recipe.getIngredients().size()==1);
        assertEquals(INGRED_TITLE, recipe.getRecipename());
        assertEquals(INGRED_DSCRIPTION, recipe.getRecipeDescriptions());
        assertEquals(INGRED_INGREDIENT, recipe.getIngredientsString());
        assertEquals(INGRED_INSTRUCTION, recipe.getRecipeinstructions());
    }
	
	public void testNoTitle() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(null, INGRED_DSCRIPTION, INGRED_INSTRUCTION, ingred , category, "userid","username");
        assertTrue("recipe should not be added without title",recipe.getIngredients().size()==0);
    }
	public void testNoDescription() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(INGRED_TITLE,null, INGRED_INSTRUCTION, ingred , category, "userid","username");
        assertTrue("recipe should not be added without ingredient",recipe.getIngredients().size()==0);
    }
	public void testNoInstruction() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(INGRED_TITLE,INGRED_DSCRIPTION, null, ingred , category, "userid","username");
        assertTrue("recipe should not be added without instruction",recipe.getIngredients().size()==0);
    }
	public void testNoIngredient() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(INGRED_TITLE,INGRED_DSCRIPTION,INGRED_INSTRUCTION, null , category, "userid","username");
        assertTrue("recipe should not be added without indredient",recipe.getIngredients().size()==0);
    }
	public void testNoCategory() {
		ArrayList<String> ingred = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		Recipe recipe = new Recipe(INGRED_TITLE,INGRED_DSCRIPTION,INGRED_INSTRUCTION, ingred , null, "userid","username");
        assertTrue("recipe should not be added without Category",recipe.getIngredients().size()==1);
    }


}
