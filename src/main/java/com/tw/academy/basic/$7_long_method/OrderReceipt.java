package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    //Deprecated
    public String printCustomerName() {
        return o.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printCustomerInfo(output);
        // prints lineItems
        double totalSalesTx = 0d;
        double totalAmount = 0d;
        printItemList(output);
        for (LineItem lineItem : o.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTx += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        PrintsTotalStateTax(output, totalSalesTx);
        PrintTotalAmount(output, totalAmount);
        return output.toString();
    }

    private void printItemList(StringBuilder output) {
        for (LineItem lineItem : o.getLineItems()) {
            printItem(output, lineItem);
        }
    }

    private void printItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private void PrintTotalAmount(StringBuilder output, double totalAmount) {
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void PrintsTotalStateTax(StringBuilder output, double totalSalesTx) {
        output.append("Sales Tax").append('\t').append(totalSalesTx);
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}