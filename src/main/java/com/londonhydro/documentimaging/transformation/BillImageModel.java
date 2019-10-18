package com.londonhydro.documentimaging.transformation;
/**
 * BillImage Bean
 * author: Faisal Nkutu
 * date: September 04 2019
 */
public class BillImageModel {
    private String invDetails;
    private String firstName;
    private String addressOne;

    public String getAddressOne() {
        return "addressOne";
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getAddressThree() {
        return addressThree;
    }

    public void setAddressThree(String addressThree) {
        this.addressThree = addressThree;
    }

    private String addressTwo;
    private String addressThree;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public String getInvDetails() {
        return invDetails;
    }

    public void setInvDetails(String invDetails) {
        this.invDetails = invDetails;
    }

    public String getRateDescription() {
        return rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    public String getPrimaryAdjustmentFactor() {
        return primaryAdjustmentFactor;
    }

    public void setPrimaryAdjustmentFactor(String primaryAdjustmentFactor) {
        this.primaryAdjustmentFactor = primaryAdjustmentFactor;
    }

    private String rateDescription;
    private String primaryAdjustmentFactor;
    public String getContractAccount() {
        return contractAccount;
    }

    public void setContractAccount(String contractAccount) {
        this.contractAccount = contractAccount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    private String contractAccount;
    private String customerNumber;
    private String invType;
    private String invoiceNumber;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(String totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public String getSummaryItem() {
        return summaryItem;
    }

    public void setSummaryItem(String summaryItem) {
        this.summaryItem = summaryItem;
    }

    public String getTotalPaymentSinceLastBill() {
        return totalPaymentSinceLastBill;
    }

    public void setTotalPaymentSinceLastBill(String totalPaymentSinceLastBill) {
        this.totalPaymentSinceLastBill = totalPaymentSinceLastBill;
    }

    public String getBalanceForward() {
        return balanceForward;
    }

    public void setBalanceForward(String balanceForward) {
        this.balanceForward = balanceForward;
    }

    public String getTotalCurrentUtilityCharges() {
        return totalCurrentUtilityCharges;
    }

    public void setTotalCurrentUtilityCharges(String totalCurrentUtilityCharges) {
        this.totalCurrentUtilityCharges = totalCurrentUtilityCharges;
    }

    public String getBudgetBillingAmountSummary() {
        return budgetBillingAmountSummary;
    }

    public void setBudgetBillingAmountSummary(String budgetBillingAmountSummary) {
        this.budgetBillingAmountSummary = budgetBillingAmountSummary;
    }

    public String getBudgetBillingAmount() {
        return budgetBillingAmount;
    }

    public void setBudgetBillingAmount(String budgetBillingAmount) {
        this.budgetBillingAmount = budgetBillingAmount;
    }

    public String getOcr() {
        return ocr;
    }

    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getMailMethod() {
        return mailMethod;
    }

    public void setMailMethod(String mailMethod) {
        this.mailMethod = mailMethod;
    }

    public String getErp() {
        return erp;
    }

    public void setErp(String erp) {
        this.erp = erp;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBillToDate() {
        return billToDate;
    }

    public void setBillToDate(String billToDate) {
        this.billToDate = billToDate;
    }

    public String getUnbilledBudgetBalance() {
        return unbilledBudgetBalance;
    }

    public void setUnbilledBudgetBalance(String unbilledBudgetBalance) {
        this.unbilledBudgetBalance = unbilledBudgetBalance;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstallationNumber() {
        return installationNumber;
    }

    public void setInstallationNumber(String installationNumber) {
        this.installationNumber = installationNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUnitsServed() {
        return unitsServed;
    }

    public void setUnitsServed(String unitsServed) {
        this.unitsServed = unitsServed;
    }

    public String getRateDiscription() {
        return rateDiscription;
    }

    public void setRateDiscription(String rateDiscription) {
        this.rateDiscription = rateDiscription;
    }

    public String getNoOfConnections() {
        return noOfConnections;
    }

    public void setNoOfConnections(String noOfConnections) {
        this.noOfConnections = noOfConnections;
    }

    public String getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
    }

    private String customerName;

    public String getActualCostToDate() {
        return actualCostToDate;
    }

    public void setActualCostToDate(String actualCostToDate) {
        this.actualCostToDate = actualCostToDate;
    }

    public String getChargeLine() {
        return chargeLine;
    }

    public void setChargeLine(String chargeLine) {
        this.chargeLine = chargeLine;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDetailCharges() {
        return detailCharges;
    }

    public void setDetailCharges(String detailCharges) {
        this.detailCharges = detailCharges;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getFromUsage() {
        return fromUsage;
    }

    public void setFromUsage(String fromUsage) {
        this.fromUsage = fromUsage;
    }

    public String getToUsage() {
        return toUsage;
    }

    public void setToUsage(String toUsage) {
        this.toUsage = toUsage;
    }

    public String getAdjustmentFactor() {
        return adjustmentFactor;
    }

    public void setAdjustmentFactor(String adjustmentFactor) {
        this.adjustmentFactor = adjustmentFactor;
    }

    public String getActualUsage() {
        return actualUsage;
    }

    public void setActualUsage(String actualUsage) {
        this.actualUsage = actualUsage;
    }

    public String getAdjustedUsage() {
        return adjustedUsage;
    }

    public void setAdjustedUsage(String adjustedUsage) {
        this.adjustedUsage = adjustedUsage;
    }

    public String getPprimaryAdjustmentFactor() {
        return PprimaryAdjustmentFactor;
    }

    public void setPprimaryAdjustmentFactor(String pprimaryAdjustmentFactor) {
        PprimaryAdjustmentFactor = pprimaryAdjustmentFactor;
    }

    public String getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(String usageHistory) {
        this.usageHistory = usageHistory;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getMeasureUnits() {
        return measureUnits;
    }

    public void setMeasureUnits(String measureUnits) {
        this.measureUnits = measureUnits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMeterData() {
        return meterData;
    }

    public void setMeterData(String meterData) {
        this.meterData = meterData;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    private String mailingAddress;
    private String totalAmountDue;
    private String summaryItem;
    private String totalPaymentSinceLastBill;
    private String balanceForward;
    private String totalCurrentUtilityCharges;
    private String budgetBillingAmountSummary;
    private String budgetBillingAmount;
    private String ocr;
    private String interestRate;
    private String mailMethod;
    private String erp;
    private String startDate;
    private String endDate;
    private String amount;
    private String billToDate;
    private String actualCostToDate;
    private String unbilledBudgetBalance;
    private String service;
    private String premise;
    private String type;
    private String installationNumber;
    private String accountNumber;
    private String unitsServed;
    private String rateDiscription;
    private String noOfConnections;
    private String totalCharges;
    private String chargeLine;
    private String display;
    private String detailCharges;
    private String unitCost;
    private String register;
    private String fromUsage;
    private String toUsage;
    private String adjustmentFactor;
    private String actualUsage;
    private String adjustedUsage;
    private String PprimaryAdjustmentFactor;
    private String usageHistory;
    private String usage;
    private String consumption;
    private String measureUnits;
    private String date;
    private String meterData;
    private String meter;




}
