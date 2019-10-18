package com.londonhydro.documentimaging.transformation;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * TemplateFactory  for all Document types
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Slf4j
public class TemplateFactory {

    //@Autowired
    private static BillImageModel billImageModel = new BillImageModel();
    private static MakeBillTemplate makeBillTemplate = new MakeBillTemplate();

    public void createBillTemplate(String fileName, Document doc){

        try {
            log.info("Creating Bill Template: " + fileName);
            if (doc!=null && doc.hasChildNodes()) {

                printNote(doc.getChildNodes());
                if(!fileName.isEmpty()) {
                    makeBillTemplate.
                            createBillTemplate(fileName, billImageModel);
                }


            }else if (doc==null){
                makeBillTemplate.createLetterOfReference(fileName, billImageModel);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }

    public static BillImageModel getBillImageModel() {
        return billImageModel;
    }

    public static void setBillImageModel(BillImageModel billImageModel) {
        TemplateFactory.billImageModel = billImageModel;
    }


    public static MakeBillTemplate getMakeBillTemplate() {
        return makeBillTemplate;
    }

    public static void setMakeBillTemplate(MakeBillTemplate makeBillTemplate) {
        TemplateFactory.makeBillTemplate = makeBillTemplate;
    }

    private static void printNote(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                log.info("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                log.info("Node Value =" + tempNode.getTextContent());
                //billImageModel.setCustomerName(tempNode.getNodeName());
                if(tempNode.getTextContent().startsWith("Previous Balance")){
                    //billImageModel.setTotalPaymentSinceLastBill(tempNode.getTextContent().substring(1,30));
                    //String previousBillSummary = "" + tempNode.getTextContent().substring(16, tempNode.getTextContent().indexOf("summary")) + "";
                    //System.out.println("previousBillSummary--------->" + previousBillSummary);

                    billImageModel.setTotalPaymentSinceLastBill("-9000.56");
                    //billImageModel.setTotalPaymentSinceLastBill(previousBillSummary.trim());
                    // billImageModel.setTotalPaymentSinceLastBill(tempNode.getTextContent().substring(15,tempNode.getTextContent().indexOf("summary1")));
                }
                if (tempNode.getNodeName().equalsIgnoreCase("CustomerInformation")){

                    if(tempNode.getTextContent()!=null) {
                        billImageModel.setMailingAddress(tempNode.getTextContent());
                    }

                }
                if (tempNode.getNodeName()!=null) {
                    if (tempNode.getNodeName().equalsIgnoreCase("OCR")) {
                        billImageModel.setOcr(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("FirstName")) {
                        billImageModel.setFirstName(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("LastName")) {
                        billImageModel.setLastName(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("MailingAddress")) {
                        billImageModel.setMailingAddress(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("addr1")) {
                        billImageModel.setAddressOne(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("addr2")) {
                        billImageModel.setAddressTwo(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("addr3")) {
                        billImageModel.setAddressThree(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("InterestRate")) {
                        billImageModel.setInterestRate(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("MailMethod")) {
                        billImageModel.setMailMethod(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("EPP")) {
                        billImageModel.setErp(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("StartDate")) {
                        billImageModel.setStartDate(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("EndDate")) {
                        billImageModel.setEndDate(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("BillToDate")) {
                        billImageModel.setBillToDate(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("ActualCostToDate")) {
                        billImageModel.setActualCostToDate(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("UnbilledBudgetBalance")) {
                        billImageModel.setUnbilledBudgetBalance(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("InvDetails")) {
                        billImageModel.setInvDetails(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("Service")) {
                        billImageModel.setService(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("InstallationNumber")) {
                        billImageModel.setInstallationNumber(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("AccountNumber")) {
                        billImageModel.setAccountNumber(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("UnitsServed")) {
                        billImageModel.setUnitsServed(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("RateDescription")) {
                        billImageModel.setRateDescription(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("NoofConnection")) {
                        billImageModel.setNoOfConnections(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("TotalCharges")) {
                        billImageModel.setTotalCharges(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("ChargeLine")) {
                        billImageModel.setChargeLine(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("DetailCharges")) {
                        billImageModel.setDetailCharges(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("UnitCost")) {
                        billImageModel.setUnitCost(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("MeterData")) {
                        billImageModel.setMeterData(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("Meter")) {
                        billImageModel.setMeter(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("Register")) {
                        billImageModel.setRegister(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("FromUsage")) {
                        billImageModel.setFromUsage(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("ToUsage")) {
                        billImageModel.setToUsage(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("AdjustmentFactor")) {
                        billImageModel.setAdjustmentFactor(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("ActualUsage")) {
                        billImageModel.setActualUsage(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("AdjustedUsage")) {
                        billImageModel.setAdjustedUsage(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("PrimaryAdjustmentFactor")) {
                        billImageModel.setPrimaryAdjustmentFactor(tempNode.getTextContent());
                    }
                    if (tempNode.getNodeName().equalsIgnoreCase("Value")) {
                        //billImageModel.setTotalAmountDue(tempNode.getTextContent());
                    }
                }
                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("Node name==>" + node.getNodeName());
                        System.out.println("Node value==>" + node.getNodeValue());
                        String nodeName = node.getNodeName();
                        if(nodeName.trim().equalsIgnoreCase("ContractAccount")){
                                billImageModel.setContractAccount(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("CustomerNumber")){
                                billImageModel.setCustomerNumber(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("InvType")){
                                billImageModel.setInvType(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("InvoiceNumber")){
                                billImageModel.setInvoiceNumber(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("Premise")){
                                billImageModel.setDate(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("type")){
                                billImageModel.setType(node.getNodeValue());
                        }

                        if(nodeName.trim().equalsIgnoreCase("date") && tempNode.getNodeName()!=null){
                                billImageModel.setDate(node.getNodeValue());
                        }
                        if(nodeName.trim().equalsIgnoreCase("MeterNumber")) {
                                billImageModel.setDate(node.getNodeValue());

                        }
                    }

                }

                if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());

                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

            }

        }

    }


}
