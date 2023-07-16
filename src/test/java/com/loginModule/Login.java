package com.loginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.AmazonBaseClass;

public class Login extends AmazonBaseClass {
	Actions action = new Actions(driver);
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	// Object Repository
	// Login Related Web Elements
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement SignIn;
	@FindBy(id = "continue")
	WebElement Continue;
	@FindBy(id = "ap_email")
	WebElement Username;
	@FindBy(id = "ap_password")
	WebElement Password;
	@FindBy(id = "signInSubmit")
	WebElement Submit;

	// Search Related Web Elements
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchText;
	@FindBy(id = "nav-search-submit-button")
	WebElement searchIcon;
	@FindBy(className = "a-color-state")
	WebElement searchResults;

	// Your Orders Related Web Elements
	@FindBy(xpath = "//h2[normalize-space()='Your Orders']")
	WebElement yourOrders;
	@FindBy(xpath = "//h1[normalize-space()='Your Orders']")
	WebElement yourOrdersText;

	// Your Payments
	@FindBy(xpath = "//h2[normalize-space()='Your Payments']")
	WebElement yourPayments;
	@FindBy(xpath = "//span[normalize-space()='Cards and accounts']")
	WebElement yourPaymentsText;
	@FindBy(xpath = "//span[@id='pp-C6fbeS-14']//input[@type='submit']")
	WebElement addPaymentMethod;
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement addCreditOrDebitCard;

	// Sort By: Feature
	@FindBy(xpath = "//span[@class='a-dropdown-prompt']")
	WebElement sortFeature;
	@FindBy(xpath = "//a[@id='s-result-sort-select_1']")
	WebElement lowToHigh;
	@FindBy(xpath = "//a[@id='s-result-sort-select_2']")
	WebElement highToLow;
	@FindBy(xpath = "//a[@id='s-result-sort-select_3']")
	WebElement customerReview;
	@FindBy(xpath = "//a[@id='s-result-sort-select_4']")
	WebElement newestArrivals;

	// Sign Out
	@FindBy(xpath = "//span[normalize-space()='Sign Out']")
	WebElement signout;

	@FindBy(xpath = "//[normalize-space()='Add a payment method']")
	WebElement addCardButton;

	// Your Address
	@FindBy(xpath = "//h2[normalize-space()='Your Addresses']")
	WebElement yourAddress;
	@FindBy(id = "ya-myab-plus-address-icon")
	WebElement addAddress;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement fullName;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement yourPhone;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement address1;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement address2;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement city;
	@FindBy(xpath = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@role='button']")
	WebElement province;
	@FindBy(xpath = "//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8']")
	WebElement selectState;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement postalCode;
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement addAddressbtn;
	@FindBy(xpath = "//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']")
	WebElement saveAddress;

	// Add to cart Elements
	@FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']")
	WebElement firstProduct;
	// Add To Cart Button Web Elements
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addtoCartbtn;
	// Cart Icon
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement cartIcon;
	// Click the quantity
	@FindBy(xpath = "//span[@class='a-dropdown-label']")
	WebElement clickQuantity;
	// Increase the Quantity
	@FindBy(xpath = "//a[@id='quantity_3']")
	WebElement increaseQuantity;
	// add different item
	@FindBy(xpath = " //div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Mens 2-Pack Crewneck T-Shirts']")
	WebElement differentitem;
	// to delete items
	@FindBy(xpath = "//input[@data-action=\"delete\"]")
	WebElement deleteItem;
	@FindBy(xpath = "//span[@class='a-truncate-full']")
	WebElement moreInfo;
	@FindBy(xpath = "//span[@id='a-autoid-1-announce']")
	WebElement deleteQuantity;
	@FindBy(xpath = "//a[@id='quantity_0']")
	WebElement zeroQuantity;

	// Remove Address
	@FindBy(id = "ya-myab-address-delete-btn-1")
	WebElement removeAddress;
	@FindBy(xpath = "//span[normalize-space()='Yes']")
	WebElement removeAddressYes;

	@FindBy(xpath = "//span[normalize-space()='01']")
	WebElement ddMonth;
	@FindBy(xpath = "//span[normalize-space()='2023']")
	WebElement ddYear;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public void addtocart() {
		searchText.sendKeys("drills");
		searchIcon.click();
		firstProduct.click();
		addtoCartbtn.click();
		cartIcon.click();
		clickQuantity.click();
		increaseQuantity.click();
		searchText.sendKeys("tshirt");
		searchIcon.click();
		differentitem.click();
		addtoCartbtn.click();
		cartIcon.click();
		deleteQuantity.click();
		zeroQuantity.click();
		moreInfo.click();
	}

	public void clickSignIn() {
		SignIn.click();
	}

	public void typeEmail(String email) {
		Username.sendKeys(email);
	}

	public void clickContinue() {
		Continue.click();
	}

	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}

	public void clickSubmit() {
		Submit.click();
	}

	public String verify() {
		return driver.getTitle();
	}

	public void login() {
		try {
			Thread.sleep(5000);
			SignIn.click();
			Username.sendKeys(username);
			Continue.click();
			Thread.sleep(2000);
			Password.sendKeys(password);
			Thread.sleep(2000);
			Submit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void signinMouseHover() throws InterruptedException {
		action.moveToElement(SignIn).build().perform();
		Thread.sleep(3000);
	}

	public void searchFeature() throws InterruptedException {
		searchText.sendKeys("apple watch");
		searchIcon.click();
		String actualResults = searchResults.getText();
		String expectedResults = "apple watch";
		// Assert.assertEquals(actualResults, expectedResults);
	}

	public void addAddress() throws InterruptedException {
		yourAddress.click();
		addAddress.click();
		fullName.sendKeys("FirstName");
		yourPhone.sendKeys("1234567890");
		address1.sendKeys("9 Lane");
		address2.sendKeys("1");
		city.sendKeys("Toronto");
		province.click();
		selectState.click();
		postalCode.sendKeys("1N1 2N1");
		addAddressbtn.click();
		saveAddress.click();
	}

	public void accessYourAccount() throws InterruptedException {
		yourOrders.click();
		Thread.sleep(1000);
		String actualOrderResults = yourOrdersText.getText();
		String expectedResults = "Your Orders";
		Assert.assertEquals(actualOrderResults, expectedResults);
	}

	public void addYourPayments() throws InterruptedException {
		yourPayments.click();
		Thread.sleep(1000);
		WebElement addCardButton = driver.findElement(By.linkText("Add a payment method"));
		addCardButton.click();
		Thread.sleep(1000);
		WebElement addCardButton1 = driver.findElement(By.className("a-button-input"));
		addCardButton1.click();
		Thread.sleep(1000);
		// Card is not getting added due to expire date
		driver.switchTo().frame(0);
		WebElement cardNumber = driver.findElement(By.name("addCreditCardNumber"));
		cardNumber.sendKeys("4987654321098769");
		Thread.sleep(1000);
		WebElement nameOnCard = driver.findElement(By.name("ppw-accountHolderName"));
		nameOnCard.sendKeys("Jacob");
		Thread.sleep(1000);
		WebElement addYourCard = driver.findElement(By.name("ppw-widgetEvent:AddCreditCardEvent"));
		addYourCard.click();
		Thread.sleep(1000);
	}

	public void addPayments() {
		addPaymentMethod.click();
		addCreditOrDebitCard.click();
	}

	public void sortByLowToHigh() throws InterruptedException {
		sortFeature.click();
		lowToHigh.click();
		Thread.sleep(2000);
	}

	public void sortByHighToLow() throws InterruptedException {
		sortFeature.click();
		highToLow.click();
		Thread.sleep(1000);
	}

	public void sortByFeatureCustomerReview() throws InterruptedException {
		sortFeature.click();
		customerReview.click();
		Thread.sleep(1000);
	}

	public void sortByFeatureNewestArrivals() throws InterruptedException {
		sortFeature.click();
		newestArrivals.click();
		Thread.sleep(1000);
	}

	public void signOut() throws InterruptedException {
		signout.click();
	}
}