package com.services.micro.gateway.order.bl;

import com.ftd.pi.ic.ftdpartners.webservices.SubmitOrderFeed;
import com.ftd.pi.ic.ftdpartners.webservices.ObjectFactory;
import com.ftd.pi.ic.ftdpartners.webservices.CreateOrderRequest;
import com.ftd.pi.ic.ftdpartners.webservices.BillingAddress;
import com.ftd.pi.ic.ftdpartners.webservices.BillingPhoneNumber;
import com.ftd.pi.ic.ftdpartners.webservices.FulFillmentAddress;
import com.ftd.pi.ic.ftdpartners.webservices.FulFillmentPhoneNumber;
import com.groupon.generated.request.Datum;
import com.groupon.generated.request.ReservationRequest;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class OrderBuilder {
    public Object build(ReservationRequest reservationRequest) throws DatatypeConfigurationException {
        ObjectFactory factory = new ObjectFactory();
        SubmitOrderFeed submitOrderFeed = new SubmitOrderFeed();
        JAXBElement<SubmitOrderFeed> submitOrderFeedJAXBElement = factory.createSubmitOrderFeed(submitOrderFeed);
        CreateOrderRequest createOrderRequest = factory.createCreateOrderRequest();

        CreateOrderRequest.FTDOrders.Order order = new CreateOrderRequest.FTDOrders.Order();
        CreateOrderRequest.FTDOrders ftdOrders = new CreateOrderRequest.FTDOrders();
        ftdOrders.setOrder(order);
        createOrderRequest.setFTDOrders(ftdOrders);
        submitOrderFeed.setFTDRequest(createOrderRequest);

        order.setPartnerId("GROUPON");
        order.setPartnerOrderID("FEM000000015");
        order.setCurrencyCode("USD");

        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        order.setOrderDate(datatypeFactory.newXMLGregorianCalendar(gc));

        CreateOrderRequest.FTDOrders.Order.OrderTotals orderTotals =
                new CreateOrderRequest.FTDOrders.Order.OrderTotals();
        orderTotals.setOrderTotal("229.8");
        orderTotals.setOrderRetailPriceTotal("179.87");
        orderTotals.setOrderSalePriceTotal("162.0");
        orderTotals.setOrderShippingServiceFeeTotal("33.98");
        orderTotals.setOrderTaxTotal("15.84");
        order.setOrderTotals(orderTotals);


        List<Datum> datumList = reservationRequest.getData();
        for (Datum datum: datumList) {
            CreateOrderRequest.FTDOrders.Order.OrderItem orderItem  =
                    new CreateOrderRequest.FTDOrders.Order.OrderItem();


//            datum.getQuantity();
//            datum.getPriceSummary().getCurrencyCode();
//            datum.getPriceSummary().getPrice().getAmount();
//            List<ReservedUnit> reservedUnitList = datum.getReservedUnits();
//            for(ReservedUnit reservedUnit: reservedUnitList) {
//                reservedUnit.getGrouponCustomerServiceId();
//                reservedUnit.getId();
//            }
//            List<PurchaserDetail> purchaserDetailList = datum.getPurchaserDetails();
//            for(PurchaserDetail purchaserDetail: purchaserDetailList) {
//                purchaserDetail.getFirstName();
//                purchaserDetail.getLastName();
//                ShippingAddress shippingAddress = purchaserDetail.getShippingAddress();
//                shippingAddress.getCountryCode();
//                shippingAddress.getStreetAddress();
//                shippingAddress.getExtendedAddress();
//                shippingAddress.getLocality();
//                shippingAddress.getRegion();
//            }

            CreateOrderRequest.FTDOrders.Order.BillingData billingData =
                    new CreateOrderRequest.FTDOrders.Order.BillingData();
            BillingAddress billingAddress = new BillingAddress();
            billingAddress.setAddress1("<![CDATA[51 South Vail Ave]]>");
            billingAddress.setCity("<![CDATA[Arlington Hts]]>");
            billingAddress.setPostalCode("<![CDATA[60005]]>");
            billingAddress.setCountry("<![CDATA[]]>");
            billingAddress.setState("<![CDATA[IL]]>");
            billingData.setAddress(billingAddress);


            CreateOrderRequest.FTDOrders.Order.BillingData.Name name =
                    new CreateOrderRequest.FTDOrders.Order.BillingData.Name();

            name.setFirstName("<![CDATA[Johny]]");
            name.setLastName("<![CDATA[Darr]]>");
            billingData.setName(name);


            BillingPhoneNumber billingPhoneNumber = new BillingPhoneNumber();
            billingPhoneNumber.setDayTimePhone("<![CDATA[9001234567]]>");
            billingPhoneNumber.setEveningPhone("<![CDATA[]]>");

            billingData.setPhoneNumber(billingPhoneNumber);
            billingData.setEmailAddress("<![CDATA[test@sodium.ftdi.com]]>");
            order.setBillingData(billingData);


            orderItem.setPartnerOrderItemID("FEM000000015-1");
            orderItem.setSKU(datum.getProductId());
            orderItem.setDeliveryEndDate("2015-03-19");
            orderItem.setDeliveryStartDate("2015-03-19");
            orderItem.setDeliveryLocationType("<![CDATA[Residential]]>");
            orderItem.setSpecialInstructions("<![CDATA[]]>");

            CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData fulfillmentData =
                    new CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData();
            FulFillmentAddress fulFillmentAddress = new FulFillmentAddress();
            fulFillmentAddress.setAddress1("<![CDATA[300 South Riverside]]>");
            fulFillmentAddress.setCity("<![CDATA[Chicago]]>");
            fulFillmentAddress.setPostalCode("<![CDATA[60606]]>");
            fulFillmentAddress.setState("<![CDATA[IL]]>");
            fulFillmentAddress.setCountry("<![CDATA[US]]>");
            fulfillmentData.setAddress(fulFillmentAddress);

            CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData.Name fName =
                    new CreateOrderRequest.FTDOrders.Order.OrderItem.FulfillmentData.Name();
            fName.setFirstName("<![CDATA[Tom]]>");
            fName.setLastName("<![CDATA[Hanks]]>");
            fulfillmentData.setName(fName);

            FulFillmentPhoneNumber fulFillmentPhoneNumber = new FulFillmentPhoneNumber();
            fulFillmentPhoneNumber.setDayTimePhone("9001234567");
            fulFillmentPhoneNumber.setEveningPhone("<![CDATA[]]>");
            fulfillmentData.setPhoneNumber(fulFillmentPhoneNumber);
            orderItem.setFulfillmentData(fulfillmentData);
            orderItem.setOccasion("<![CDATA[Congratulations]]>");

            CreateOrderRequest.FTDOrders.Order.OrderItem.GiftWrapData giftWrapData =
                    new CreateOrderRequest.FTDOrders.Order.OrderItem.GiftWrapData();
            giftWrapData.setGiftWrapMessage("<![CDATA[Way To GO!]]>");
            orderItem.setGiftWrapData(giftWrapData);

            CreateOrderRequest.FTDOrders.Order.OrderItem.ItemPrice itemPrice =
                    new CreateOrderRequest.FTDOrders.Order.OrderItem.ItemPrice();
            itemPrice.setItemTotal(new BigDecimal("114.90"));
            itemPrice.setItemRetailPrice(new BigDecimal("89.99"));
            itemPrice.setItemSalePrice(new BigDecimal("81.00"));
            itemPrice.setItemShippingServiceFeeTotal("16.99");
            itemPrice.setItemTaxTotal("7.92");
            itemPrice.setItemDiscountCode("12345");

            orderItem.setItemPrice(itemPrice);

            order.getOrderItem().add(orderItem);


        }

        return submitOrderFeedJAXBElement;
    }

}
