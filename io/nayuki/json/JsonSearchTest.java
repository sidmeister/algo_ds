/* 
 * JSON library test
 * 
 * Copyright (c) 2015 Project Nayuki
 * http://www.nayuki.io/page/json-library-java
 * 
 * (MIT License)
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * - The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 * - The Software is provided "as is", without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and noninfringement. In no event shall the
 *   authors or copyright holders be liable for any claim, damages or other
 *   liability, whether in an action of contract, tort or otherwise, arising from,
 *   out of or in connection with the Software or the use or other dealings in the
 *   Software.
 */

package io.nayuki.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;


/**
 * A JUnit test suite for the {@link Json} class.
 */
public final class JsonSearchTest {
	
	@Test public void testRoundTrip() {
		Object[] cases = {
			// Constants
			null,
			true,
			false,
			// Numbers
			0,
			1,
			-1,
			Long.MIN_VALUE,
			Long.MAX_VALUE,
			0.2,
			Math.PI,
			-7.8,
			0.0f,
			1e30f,
			BigInteger.ONE.shiftLeft(256),
			new BigDecimal("1.234567891011121314151617181920"),
			// Strings
			"",
			"a",
			"Hello world!",
			"\"",
			"\\",
			"\\\"",
			"a \b c d / \n\r\t \f \u007F",
		};
		for (Object cs : cases)
			testRoundTrip(cs);
		
		// Arrays
		List<Object> lst = new ArrayList<Object>();
		testRoundTrip(lst);
		lst.add(false);
		testRoundTrip(lst);
		lst.add(true);
		testRoundTrip(lst);
		lst.add(null);
		lst.add(5);
		lst.add(true);
		lst.add("xyz");
		testRoundTrip(lst);
		lst.add(0, new ArrayList<Object>());
		testRoundTrip(lst);
		
		// Objects
		Map<String,Object> map = new HashMap<String,Object>();
		testRoundTrip(map);
		map.put("a", -52);
		testRoundTrip(map);
		map.put("\b", lst);
		testRoundTrip(map);
		map.put(" ", new TreeMap<String,Object>());
		testRoundTrip(map);
	}
	
	
	@Test public void testWhitespaceEquivalence() {
		String[] cases = {
				{ "_id" : 8968866341 , "classIndicator" : "H" , "className" : "hotwire.biz.search.hotel.MobileApiHotelSearchJdo" , "npSearchInputValidation" : { "classIndicator" : "hotwire.biz.search.hotel.HotelSearchInputValidation" , "destResolution" : { "userInput" : "Magnificent Mile, Chicago, Illinois, United States of America" , "selectedCityId" : 0 , "matchType" : 1 , "matchedObjectType" : 13} , "statusCode" : 1 , "destStatusCode" : 0 , "validationHwErrorCode" : -1 , "selectedNeighborhoodIdList" : [ 87545 , 88719 , 93845 , 96585 , 13750 , 89888 , 87951 , 90776 , 94012 , 91205 , 87548 , 90133 , 90900 , 89889 , 87952 , 88720 , 89905 , 13950 , 92973 , 87547 , 87948 , 89906 , 87953 , 89904 , 90155 , 14000 , 90202 , 90361 , 87947 , 89442] , "isNewSearchRequired" : false , "resolvedUserInput" : "Magnificent Mile, Chicago, Illinois, United States of America"} , "startDate" : { "$date" : "2015-10-13T07:00:00.000Z"} , "endDate" : { "$date" : "2015-10-14T07:00:00.000Z"} , "quantity" : 1 , "rateCode" : 0 , "npSolutionListIds" : [ 443309111366 , 443309111367 , 443309111368 , 443309111369 , 443309111370 , 443309111371 , 443309111372 , 443309111373 , 443309111374 , 443309111375 , 443309111376 , 443309111377 , 443309111378 , 443309111379 , 443309111380 , 443309111381 , 443309111382 , 443309111383 , 443309111384 , 443309111385 , 443309111386 , 443309111387 , 443309111388 , 443309111390 , 443309111391 , 443309111392 , 443309111394 , 443309111395 , 443309111396 , 443309111397 , 443309111398 , 443309111400 , 443309111401 , 443309111402 , 443309111403 , 443309111404 , 443309111405 , 443309111406 , 443309111407 , 443309111408 , 443309111409 , 443309111410 , 443309111411 , 443309111412 , 443309111413 , 443309111414 , 443309111415 , 443309111416 , 443309111417 , 443309111418 , 443309111419 , 443309111420 , 443309111421 , 443309111422 , 443309111423 , 443309111424 , 443309111425 , 443309111426 , 443309111427 , 443309111428 , 443309111429 , 443309111430 , 443309111431 , 443309111432 , 443309111433 , 443309111434 , 443309111435 , 443309111436 , 443309111438 , 443309111439 , 443309111440 , 443309111442 , 443309111443 , 443309111444 , 443309111445 , 443309111446 , 443309111447 , 443309111448 , 443309111449 , 443309111450 , 443309111451 , 443309111452 , 443309111453 , 443309111454 , 443309111455 , 443309111456 , 443309111457 , 443309111458 , 443309111459 , 443309111460 , 443309111461 , 443309111466 , 443309111467 , 443309111468 , 443309111469 , 443309111470 , 443309111471 , 443309111472 , 443309111473 , 443309111475 , 443309111476 , 443309111477 , 443309111478 , 443309111479 , 443309111480 , 443309111481 , 443309111482 , 443309111484 , 443309111485 , 443309111486 , 443309111487 , 443309111488 , 443309111489 , 443309111490 , 443309111491 , 443309111492 , 443309111493 , 443309111494 , 443309111495 , 443309111496 , 443309111497 , 443309111499 , 443309111500 , 443309111501 , 443309111502 , 443309111503 , 443309111504 , 443309111505 , 443309111506 , 443309111507 , 443309111508 , 443309111509 , 443309111510 , 443309111511 , 443309111513 , 443309111514 , 443309111515 , 443309111516 , 443309111517 , 443309111518 , 443309111519 , 443309111520 , 443309111522 , 443309111523 , 443309111524 , 443309111525 , 443309111526 , 443309111527 , 443309111528 , 443309111529 , 443309111530 , 443309111531 , 443309111532 , 443309111533 , 443309111534 , 443309111535 , 443309111536 , 443309111537 , 443309111538 , 443309111539 , 443309111540 , 443309111542 , 443309111544 , 443309111546 , 443309111547 , 443309111548 , 443309111549 , 443309111550 , 443309111551 , 443309111553 , 443309111554 , 443309111555 , 443309111557 , 443309111558 , 443309111559 , 443309111560 , 443309111562 , 443309111563 , 443309111564 , 443309111565 , 443309111566 , 443309111567 , 443309111568 , 443309111569 , 443309111570 , 443309111571 , 443309111572 , 443309111573 , 443309111574 , 443309111575 , 443309111576 , 443309111577 , 443309111578 , 443309111579 , 443309111581 , 443309111582 , 443309111583 , 443309111584 , 443309111586 , 443309111587 , 443309111589 , 443309111592 , 443309111593 , 443309111594 , 443309111595 , 443309111596 , 443309111597 , 443309111598 , 443309111599 , 443309111600 , 443309111601 , 443309111602 , 443309111603 , 443309111604 , 443309111605 , 443309111606 , 443309111607 , 443309111608 , 443309111609 , 443309111610 , 443309111618 , 443309111798 , 443309111625 , 443309111621 , 443309111652 , 443309111629 , 443309111793 , 443309111611 , 443309111785 , 443309111787 , 443309111723 , 443309111676 , 443309111623 , 443309111790 , 443309111655 , 443309111719 , 443309111800 , 443309111731 , 443309111631 , 443309111613 , 443309111772 , 443309111705 , 443309111757 , 443309111627 , 443309111796 , 443309111643 , 443309111684 , 443309111662 , 443309111739 , 443309111680 , 443309111767 , 443309111682 , 443309111612 , 443309111806 , 443309111776 , 443309111619 , 443309111730 , 443309111691 , 443309111771 , 443309111696 , 443309111710 , 443309111628 , 443309111733 , 443309111638 , 443309111769 , 443309111748 , 443309111765 , 443309111766 , 443309111670 , 443309111746 , 443309111698 , 443309111803 , 443309111700 , 443309111657 , 443309111692 , 443309111728 , 443309111642 , 443309111741 , 443309111639 , 443309111673 , 443309111755 , 443309111675 , 443309111616 , 443309111810 , 443309111651 , 443309111690 , 443309111685 , 443309111647 , 443309111659 , 443309111635 , 443309111718 , 443309111636 , 443309111703 , 443309111713 , 443309111751 , 443309111617 , 443309111737 , 443309111708 , 443309111641 , 443309111712 , 443309111693 , 443309111653 , 443309111808 , 443309111615 , 443309111706 , 443309111782 , 443309111695 , 443309111633 , 443309111622 , 443309111686 , 443309111665 , 443309111671 , 443309111689 , 443309111764 , 443309111667 , 443309111704 , 443309111738 , 443309111714 , 443309111762 , 443309111645 , 443309111732 , 443309111620 , 443309111702 , 443309111721 , 443309111752 , 443309111660 , 443309111722 , 443309111758 , 443309111632 , 443309111701 , 443309111779 , 443309111726 , 443309111697 , 443309111679 , 443309111699 , 443309111674 , 443309111656 , 443309111797 , 443309111735 , 443309111809 , 443309111780 , 443309111646 , 443309111770 , 443309111775 , 443309111683 , 443309111614 , 443309111749 , 443309111799 , 443309111778 , 443309111678 , 443309111727 , 443309111783 , 443309111788 , 443309111677 , 443309111634 , 443309111626 , 443309111725 , 443309111724 , 443309111672 , 443309111650 , 443309111658 , 443309111644 , 443309111754 , 443309111794 , 443309111716 , 443309111681 , 443309111630 , 443309111736 , 443309111804 , 443309111801 , 443309111742 , 443309111687 , 443309111786 , 443309111709 , 443309111789 , 443309111773 , 443309111648 , 443309111781 , 443309111717 , 443309111795 , 443309111694 , 443309111711 , 443309111664 , 443309111805 , 443309111666 , 443309111747 , 443309111637 , 443309111777 , 443309111649 , 443309111756 , 443309111654 , 443309111802 , 443309111759 , 443309111768 , 443309111763 , 443309111743 , 443309111753 , 443309111669 , 443309111744 , 443309111663 , 443309111661 , 443309111624 , 443309111720 , 443309111688 , 443309111640 , 443309111784 , 443309111791 , 443309111740 , 443309111760 , 443309111761 , 443309111792 , 443309111734 , 443309111715 , 443309111774 , 443309111668 , 443309111707 , 443309111729 , 443309111745 , 443309111750 , 443309111807] , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "searchDay" : 20151013 , "stringOfVersionedProperties" : "#Tue Oct 13 13:21:09 PDT 2015\nhotwire.biz.search.hotel.canDisplayReviews=true\nhotwire.view.web.form.hotel.shouldDisplayOpaqueHotelDetails=true\nhotwire.biz.search.hotel.dtaRuleVersionForCRS=0\nhotwire.view.web.form.hotel.details.tripAdvisor.isEnabled=true\nhotwire.view.web.form.hotel.shouldDisplayEscapeHatch=true\nhotwire.biz.search.hotel.vtPricelineBuster=false\nhotwire.biz.search.hotel.shouldUseSmartRanking=false\nhotwire.biz.search.hotel.shouldCompareAgainstHotelPub=false\nhotwire.biz.search.hotel.shouldApplyMktLvlFiltersForWinnerSelection=false\nhotwire.biz.search.hotel.shouldEnableBedTypeSolution=true\nhotwire.view.web.desktop.search.useRowAutocompleteData=false\nhotwire.biz.search.hotel.shouldUsePercentRecommendInCompset=true\nhotwire.view.web.form.hotel.results.showAirportBonusHoods=true\nhotwire.view.web.form.hotel.results.canDisplayReviewRecommendationOnResults=true\nhotwire.biz.search.hotel.enable.nightFallDiscount=true\nhotwire.biz.search.hotel.shouldApplyUBSSorting=false\nhotwire.view.web.desktop.search.retailTabFirst=false\nhotwire.biz.search.hotel.shouldUseMultyHotelCompset=false\nhotwire.eis.crs.hotel.ian.adjustProNetRate=true\nhotwire.view.web.form.hotel.results.showPaidAmenity=true\nhotwire.biz.search.hotel.shouldUseSmartTieBand=false\nhotwire.biz.search.hotel.hotelStarRatingUpsell=false\nhotwire.biz.search.hotel.dtaRuleVersionForCRS_Destination=0\nhotwire.biz.search.hotel.disableAlternateSupply=c\nhotwire.biz.search.hotel.maxRetailHotelForProcessing=200\nhotwire.biz.search.hotel.dtaRuleVersionForCRS_Hotel=0\nhotwire.biz.search.hotel.dtaRuleVersionForCRS_DestinationChain=0\nhotwire.biz.search.hotel.scoringServiceModelId=5\nhotwire.view.web.form.hotel.results.showAirportBonusHoodsAsExpanded=true\n" , "npStatus" : { "classIndicator" : "hotwire.biz.search.SynchronousMTSearchStatus" , "startTime" : 0 , "startedTaskCount" : 1 , "completedTaskCount" : 0 , "isCallbackNeeded" : true , "isSearchAborted" : false , "code" : 2} , "crsQueryStarttime" : 1444767666795 , "processingStartTime" : 1444767667507 , "processingEndtime" : 1444767669470 , "serverName" : "tcbiz10_5" , "referralSource" : 0 , "npLastSearchReferralSource" : 0 , "clientId" : 6671850082498374091 , "isAuthenticated" : false , "npIsPersistent" : true , "npShouldSkipPersistence" : false , "localDistanceToCustomer" : "0.0" , "pricingFactors" : { "markupTreatmentCode" : -1 , "pricingVersionId" : "3" , "pricingVersionDate" : { "$date" : "2015-10-13T20:21:08.265Z"}} , "destinationGeoPoint" : { "latitude" : 41.897478 , "longitude" : -87.652039} , "dealsPriceRuleDesc" : "" , "searchType" : 0 , "subSearchList" : [ ] , "npShouldDoLiveSearch" : true , "nodeType" : "M" , "quoterType" : 10200 , "npValidationHwErrorCode" : -1 , "npResultStatusCode" : 1000 , "referralList" : [ { "searchId" : 8968866341 , "referralDate" : { "$date" : "2015-10-13T20:19:47.684Z"} , "linkId" : "B90016400" , "keywordId" : "K3605571" , "referrerId" : "S526" , "matchTypeId" : "M03" , "accountId" : "AC90000" , "campaignId" : "CM900018" , "referralTypeCode" : "O" , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "isLongTerm" : false , "searchDay" : 20151013 , "deeplinkNeighborhoodId" : 0 , "deeplinkDisplayPrice" : "0.0" , "deeplinkStarRating" : "0.0" , "deeplinkSolutionId" : 0 , "deeplinkSearchId" : 0}] , "reportingJDO_List" : [ ] , "numSellableRetail" : 0 , "masterSearchId" : 0 , "isLongTerm" : false , "geoInfo" : { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "ndmaCode" : 0 , "gmtOffset" : "-8.0" , "geoInfoSource" : "R" , "geoPoint" : { "latitude" : 41.84885 , "longitude" : -87.671249}} , "userMetaData" : { "customerId" : -1 , "customerHasMadePurchases" : true , "siteType" : 1005 , "deviceType" : 1200 , "siteId" : 1 , "locale" : "en_US"} , "PCR_State" : "N" , "searchPurchaseLikelihood" : "0.047596756" , "searchHttpSession" : { "httpSessionId" : "ABF1DF3AF13198217F8C9571C2A07EBF" , "rawUserAgentString" : "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)"} , "destInputMatchType" : "C" , "origInputMatchType" : "" , "npCanBeSearchedConcurrently" : false , "npShouldValidateMaxStayLength" : true , "npCustLastDMAId" : 0 , "npIsRepeatQuoter" : false , "gaiaId" : 6130114 , "npSearchTokenId" : 8968866341 , "channelId" : "HFE@2.26.6" , "crsTypeCode2TxCountMap" : { } , "numberOfAdults" : 2 , "numberOfChildren" : 0 , "nearbyNeighborhoodSearchStatsList" : [ { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87545 , "minDistance" : 1.0 , "maxDistance" : 2.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "5.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 88719 , "minDistance" : 0.75 , "maxDistance" : 2.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "5.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 93845 , "minDistance" : 1.0 , "maxDistance" : 2.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 96585 , "minDistance" : 1.5 , "maxDistance" : 2.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 13750 , "minDistance" : 1.5 , "maxDistance" : 2.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89888 , "minDistance" : 1.5 , "maxDistance" : 3.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87951 , "minDistance" : 2.5 , "maxDistance" : 4.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90776 , "minDistance" : 7.0 , "maxDistance" : 7.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 94012 , "minDistance" : 7.0 , "maxDistance" : 8.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 91205 , "minDistance" : 7.75 , "maxDistance" : 8.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "2.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87548 , "minDistance" : 9.0 , "maxDistance" : 13.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90133 , "minDistance" : 11.0 , "maxDistance" : 13.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90900 , "minDistance" : 13.25 , "maxDistance" : 15.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "2.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89889 , "minDistance" : 10.5 , "maxDistance" : 16.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87952 , "minDistance" : 7.25 , "maxDistance" : 17.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 88720 , "minDistance" : 10.75 , "maxDistance" : 18.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89905 , "minDistance" : 17.75 , "maxDistance" : 20.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 13950 , "minDistance" : 14.5 , "maxDistance" : 21.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 92973 , "minDistance" : 20.5 , "maxDistance" : 21.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "2.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87547 , "minDistance" : 16.0 , "maxDistance" : 22.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87948 , "minDistance" : 13.75 , "maxDistance" : 22.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89906 , "minDistance" : 19.25 , "maxDistance" : 22.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87953 , "minDistance" : 16.25 , "maxDistance" : 22.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "2.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89904 , "minDistance" : 19.25 , "maxDistance" : 22.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "2.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90155 , "minDistance" : 20.5 , "maxDistance" : 24.25 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 14000 , "minDistance" : 21.5 , "maxDistance" : 25.0 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "4.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90202 , "minDistance" : 19.0 , "maxDistance" : 25.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 90361 , "minDistance" : 23.25 , "maxDistance" : 25.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.5" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 87947 , "minDistance" : 23.5 , "maxDistance" : 27.5 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false} , { "searchId" : 8968866341 , "searchDate" : { "$date" : "2015-10-13T20:21:07.507Z"} , "neighborhoodId" : 89442 , "minDistance" : 22.25 , "maxDistance" : 27.75 , "npIsWithinPrimaryRadius" : true , "maxStarRating" : "3.0" , "isExpandedHood" : false}] , "searchRadius" : "25.0" , "requestedRetailHotelId" : 0 , "npRegionNeighborhoodIds" : [ ] , "rateTypes" : [ "REGULAR_OPAQUE_RATE"] , "npDestinationCity" : { "oid" : 4869 , "name" : "CHICAGO" , "displayName" : "Chicago" , "displayRank" : 199 , "stateId" : 32 , "primaryAirportCode" : "ORD" , "timeZoneRaw" : -6 , "timeZoneName" : "America/Chicago" , "geoPoint" : { "latitude" : 41.897478 , "longitude" : -87.652039} , "NDMA_Id" : 2000037 , "daylightSavingsInd" : "Y" , "clusterId" : 0} , "gaiaHotelId" : 0 , "clientLatLong" : { "latitude" : 41.84885025024414 , "longitude" : -87.67124938964844}}
		};
		for (String cs : cases)
			assertJsonEquals(Json.parse(cs[0]));
	}
	
	
	@Test public void testInvalid() {
		String[] cases = {
			"",
			"  ",
			"a",
			"false\"",
			"trues",
			"null1",
			"*",
			"00",
			"01",
			"08",
			"+0",
			"+2",
			"+2.3",
			"2.3.4",
			"2e2e2",
			"2e++0",
			"2e+-0",
			"2e--0",
			"2f",
			"0x10",
			"0 0",
			"0,0",
			"0 //",
			"\"",
			"\"\\",
			"\"\\\"",
			"\"\"\"",
			"\"\\a\"",
			"\"\\x00\"",
			"\"\\u+000\"",
			"\"\\u-000\"",
			"\"\u0000\"",
			"\"\n\"",
			"\"a\tb\"",
			"\"ab\rcd\"",
			"[",
			"]",
			"{",
			"}",
			"[}",
			"[,]",
			"[0,]",
			"[5 4]",
			"[5, 4,]",
			"[\"a\" \"b\"]",
			"[\"cc\" 3]",
			"[[]",
			"][",
			"[\"]",
			"{abc:0}",
			"{null:true}",
			"{\"a\":1,}",
			"{\"a\":1 \"b\":2}",
			"{}{}",
			"{{}}",
		};
		for (String cs : cases) {
			try {
				Json.parse(cs);
				fail();
			} catch (IllegalArgumentException e) {}  // Pass
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	private static void assertJsonEquals(Object expect, Object actual) {
		if (expect == null || actual == null) {
			assertTrue(expect == null && actual == null);
			
		} else if (expect instanceof CharSequence || expect instanceof Boolean) {
			assertEquals(expect, actual);
			
		} else if (expect instanceof Number) {
			Number exp = (Number)expect;
			Number act = (Number)actual;
			if      (exp instanceof Byte   ) assertEquals(exp.byteValue  (), act.byteValue  ());
			else if (exp instanceof Short  ) assertEquals(exp.shortValue (), act.shortValue ());
			else if (exp instanceof Integer) assertEquals(exp.intValue   (), act.intValue   ());
			else if (exp instanceof Long   ) assertEquals(exp.longValue  (), act.longValue  ());
			else if (exp instanceof Float  ) assertEquals(exp.floatValue (), act.floatValue (), 0);
			else if (exp instanceof Double ) assertEquals(exp.doubleValue(), act.doubleValue(), 0);
			else if (exp instanceof BigInteger) assertEquals(exp, ((JsonNumber)act).bigIntegerValue());
			else if (exp instanceof BigDecimal) assertEquals(exp, ((JsonNumber)act).bigDecimalValue());
			else if (exp instanceof JsonNumber) assertEquals(exp, act);
			else throw new AssertionError("Not implemented");
			
		} else if (expect instanceof List) {
			List exp = (List)expect;
			List act = (List)actual;
			assertEquals(exp.size(), act.size());
			for (int i = 0; i < exp.size(); i++)
				assertJsonEquals(exp.get(i), act.get(i));
			
		} else if (expect instanceof Map) {
			Map exp = (Map)expect;
			Map act = (Map)actual;
			assertEquals(exp.size(), act.size());
			for (Object key : exp.keySet()) {
				assertTrue(key instanceof CharSequence);
				assertTrue(act.containsKey(key));
				assertJsonEquals(exp.get(key), act.get(key));
			}
			
		} else {
			fail("Unrecognized type");
		}
	}
	
	
	private static void testRoundTrip(Object root) {
		String enc = Json.serialize(root);
		Object dec = Json.parse(enc);
		assertJsonEquals(root, dec);
	}
	
}
