package demo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.pages.ProductSearch;
import demo.utils.ElementUtils;
import demo.utils.FileUtil;
import demo.utils.ElementUtils.LocatorStrategy;

public class Tests {
	
	private ProductSearch productSearch;
	private String filePath = "./src/test/java/assignment/test_data/test_data.properties";
	
	@BeforeClass(groups = "tests")
	public void init() {
		productSearch = new ProductSearch();
	}
	
	@Test(priority = 1, groups = "tests")
	public void productSearch() throws Exception {
		productSearch.searchProduct(FileUtil.readFromPropertyFile(filePath, "productGroup"), FileUtil.readFromPropertyFile(filePath, "productName"));
	}
	
	@Test(priority = 2, groups = "tests")
	public void productAddToCart() {
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CART").click();
		ElementUtils.wait(6);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "CART").click();
	}
	
	@Test(priority = 3, groups = "tests")
	public void verifyProductNameInCart() {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, 
				FileUtil.readFromPropertyFile(filePath, "productName")).isDisplayed());
	}
	
	@Test(priority = 4, groups = "tests")
	public void verifyProductSizeInCart() {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, 
				FileUtil.readFromPropertyFile(filePath, "productSize")).isDisplayed());
	}
	
	@Test(priority = 5, groups = "tests")
	public void verifyProductPriceInCart() {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, 
				FileUtil.readFromPropertyFile(filePath, "productPrice")).isDisplayed());
	}
	
	@Test(priority = 6, groups = "tests")
	public void removeProductFromCart() {
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, "Remove").click();
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, 
				FileUtil.readFromPropertyFile(filePath, "productPrice")).isDisplayed());
	}

}