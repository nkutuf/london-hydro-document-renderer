<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery" xmlns:n01="http://londonhydro.com/Matrix/BILL/BillPrint" version="2.0">
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.6in" margin-right="0.6in" margin-top="0.79in" margin-bottom="0.79in">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="default-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <xsl:variable name="DefaultDocument" select="."/>
                        <fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <fo:block color="red" font-size="8pt">
                                                        <fo:external-graphic background="transparent" width="50pt" content-width="scale-to-fit" height="80pt" content-height="scale-to-fit" scaling="non-uniform" src="url(./src/main/resources/LondonHydroLogoColor.svg)"/>
                                                        111 Horton St P.O.Box 3060 London ON N6A 4JB
                                                        <fo:block/>
                                                        <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@InvoiceNumber"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/MailingAddress"/>
                                                    </fo:block>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <fo:block>
                                                        <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                                            <fo:table-column/>
                                                            <fo:table-column/>
                                                            <fo:table-column/>
                                                            <fo:table-body>
                                                                <fo:table-row>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                                        <fo:block>
                                                                            <xsl:text>Billing Number:</xsl:text>
                                                                        </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                                        <fo:block>
                                                                            <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@ContractAccount"/>
                                                                        </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                                        <fo:block/>
                                                                    </fo:table-cell>
                                                                </fo:table-row>
                                                            </fo:table-body>
                                                        </fo:table>
                                                    </fo:block>
                                                    <fo:block>
                                                        <fo:block>
<xsl:text>
Please use the billing number above when paying online.
</xsl:text>
                                                        </fo:block>
                                                        <fo:block>
<xsl:text>
This bill may be paid at most financial instituitions
</xsl:text>
                                                        </fo:block>
                                                        <fo:block>
                                                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                                                <fo:table-column/>
                                                                <fo:table-column/>
                                                                <fo:table-body>
                                                                    <fo:table-row>
                                                                        <fo:table-cell background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:text>Billing </xsl:text>
                                                                                <fo:inline>
                                                                                    <xsl:text>Date</xsl:text>
                                                                                </fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/@date"/>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:text>Total Amount Due</xsl:text>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                                                <xsl:value-of select="$summaryItem[5]"/>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:text>Due Date</xsl:text>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" >
                                                                            <fo:block>
                                                                                <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                                                <xsl:value-of select="$summaryItem[6]"/>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                    </fo:table-row>
                                                                </fo:table-body>
                                                            </fo:table>
                                                        </fo:block>
                                                        <fo:block>
<xsl:text>
Interest charges of 1.5% per month (19.56% per year) will be applied on all over dues charges
</xsl:text>
                                                        </fo:block>
                                                        <xsl:text>Please for your record - DO NOT PAY.</xsl:text>
                                                    </fo:block>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                            <fo:block>
                                <xsl:text> </xsl:text>
                            </fo:block>
                            <fo:block>
                                <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/OCR"/>
                            </fo:block>
                            <fo:block> </fo:block>
                            <fo:block>
                                <xsl:text> </xsl:text>
                            </fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell background-color="#808080" border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    Bill Summary - Billing Number
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@ContractAccount"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Previous Balance</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block> $ </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[9]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:text>Billing Date</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/@date"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Total Payment since last bill   </xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block> $ </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[8]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:text>Customer Name</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/DisplayName"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Total Current Utility Charges</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>$</fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[10]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:text>Customer Number</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@CustomerNumber"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Budget Billing Amount</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block> $ </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[11]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:text>Mailing Postal Code</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/MailingAddress/postal_code"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>(Total HST )</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block> $ </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[8]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Total Amount Due</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block> $ </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[5]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Credit Balance</xsl:text>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[6]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell background-color="#808080" border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/@Premise[1]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:text>Your Electricity Charges</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block background-color="white" font-size="10pt">
                                                    Meter Number
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/MeterData/Meter/@MeterNumber"/>
                                                    Service Numer 183695
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <fo:external-graphic background="transparent" width="50pt" content-width="scale-to-fit" height="80pt" content-height="scale-to-fit" scaling="non-uniform" src="url(./src/main/resources/LondonHydroLogo.svg)"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryDates" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@date"/>
                                                    <xsl:value-of select="$usageHistoryDates[1]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryDates" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@date"/>
                                                    <xsl:value-of select="$usageHistoryDates[2]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryDates" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@date"/>
                                                    <xsl:value-of select="$usageHistoryDates[3]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryDates" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@date"/>
                                                    <xsl:value-of select="$usageHistoryDates[4]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block background-color="white" font-size="10pt">
                                                    <fo:inline background-color="green" padding-left="10mm">

                                                        <fo:inline background-color="blue" padding-left="20mm"> </fo:inline>
                                                        <fo:inline background-color="grey" padding-left="5mm"> </fo:inline>
                                                    </fo:inline>
                                                </fo:block>
                                                <fo:block background-color="white" font-size="10pt">
                                                    <fo:inline background-color="green" padding-left="10mm">

                                                        <fo:inline background-color="blue" padding-left="15mm"> </fo:inline>
                                                        <fo:inline background-color="grey" padding-left="5mm"> </fo:inline>
                                                    </fo:inline>
                                                </fo:block>
                                                <fo:block background-color="white" font-size="10pt">
                                                    <fo:inline background-color="green" padding-left="10mm">

                                                        <fo:inline background-color="blue" padding-left="6mm"> </fo:inline>
                                                        <fo:inline background-color="grey" padding-left="5mm"> </fo:inline>
                                                    </fo:inline>
                                                </fo:block>
                                                <fo:block background-color="white" font-size="10pt">
                                                    <fo:inline background-color="green" padding-left="10mm">

                                                        <fo:inline background-color="blue" padding-left="4mm"> </fo:inline>
                                                        <fo:inline background-color="grey" padding-left="5mm"> </fo:inline>
                                                    </fo:inline>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryConsumption" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@Consumption"/>
                                                    <xsl:value-of select="$usageHistoryConsumption[1]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryConsumption" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@Consumption"/>
                                                    <xsl:value-of select="$usageHistoryConsumption[2]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryConsumption" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@Consumption"/>
                                                    <xsl:value-of select="$usageHistoryConsumption[3]"/>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="usageHistoryConsumption" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/UsageHistory/Usage/@Consumption"/>
                                                    <xsl:value-of select="$usageHistoryConsumption[4]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                        </fo:block>
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                            <fo:block font-weight="bold"> Terms on your statement </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" >
                                            <fo:block>
                                                Electricity: This is the cost of the electricity supplied to you during this billing period and is the part of the bill that is subject to competition. Delivery: These are the costs of delivering electricity from generating stations across the province to London Hydro, then to your home or business. This includes the costs to build and maintain the transmission and distribution lines, towers and poles and operate provincial and local electricity systems. A portion of these charges are fixed and do not change from month to month. The rest are variable and increase or decrease depending on the amount of electricity that you use. The delivery charge also includes costs related to electricity lost through distributing electricity to your home or business.* London Hydro collects this money and pays this amount directly to our suppliers. * When electricity is delivered over a power line, it is normal for a small amount of power to be consumed or lost as heat. Equipment, such as wires and transformers, consumes power before it gets to your home or business. Regulatory Charges: Regulatory Charges are the costs of administering the wholesale electricity system and maintaining the reliability of the provincial grid. Global Adjustment: Electricity generators in Ontario receive a combination of payments from the operation of the wholesale market, payments set by regulation and payments under contracts. Your portion of the net adjustments arising from these and other authorized payments is included on your bill as the Global Adjustment. Note: For a detailed explanation of electricity terms, please visit
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
        <!--
         Stylus Studio meta-information - (c) 2004-2009. Progress Software Corporation. All rights reserved.

        <metaInformation>
            <scenarios>
                <scenario default="yes" name="Scenario1" userelativepaths="yes" externalpreview="no" url="074001057395.XML" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="yes" profilemode="0" profiledepth="" profilelength="" urlprofilexml=""
                          commandline="" additionalpath="" additionalclasspath="" postprocessortype="renderx" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator="">
                    <advancedProp name="bSchemaAware" value="true"/>
                    <advancedProp name="xsltVersion" value="2.0"/>
                    <advancedProp name="schemaCache" value="||"/>
                    <advancedProp name="iWhitespace" value="0"/>
                    <advancedProp name="bWarnings" value="true"/>
                    <advancedProp name="bXml11" value="false"/>
                    <advancedProp name="bUseDTD" value="false"/>
                    <advancedProp name="bXsltOneIsOkay" value="true"/>
                    <advancedProp name="bTinyTree" value="true"/>
                    <advancedProp name="bGenerateByteCode" value="true"/>
                    <advancedProp name="bExtensions" value="true"/>
                    <advancedProp name="iValidation" value="0"/>
                    <advancedProp name="iErrorHandling" value="fatal"/>
                    <advancedProp name="sInitialTemplate" value=""/>
                    <advancedProp name="sInitialMode" value=""/>
                </scenario>
            </scenarios>
            <MapperMetaTag>
                <MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no">
                    <SourceSchema srcSchemaPath="074001057395.XML" srcSchemaRoot="n0:MT_BillPrint" AssociatedInstance="" loaderFunction="document" loaderFunctionUsesURI="no"/>
                </MapperInfo>
                <MapperBlockPosition>
                    <template match="/">
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[7]/fo:table/fo:table-body/fo:table-row[1]/fo:table-cell[4]/fo:block/xsl:choose" x="230" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[7]/fo:table/fo:table-body/fo:table-row[1]/fo:table-cell[4]/fo:block/xsl:choose/xsl:when/fo:block/fo:block[3]/xsl:choose" x="230" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[7]/fo:table/fo:table-body/fo:table-row[2]/fo:table-cell/fo:block/xsl:if/=[0]" x="154" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[7]/fo:table/fo:table-body/fo:table-row[2]/fo:table-cell/fo:block/xsl:if" x="200" y="0"/>
                        <block path="" x="230" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[7]/fo:table/fo:table-body/fo:table-row[2]/fo:table-cell/fo:block/xsl:for-each" x="230" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[9]/xsl:choose" x="230" y="0"/>
                        <block path="fo:root/fo:page-sequence/fo:flow/fo:block/fo:block/fo:block[9]/xsl:choose/xsl:when/fo:block/xsl:choose" x="230" y="0"/>
                    </template>
                </MapperBlockPosition>
                <TemplateContext></TemplateContext>
                <MapperFilter side="source"></MapperFilter>
            </MapperMetaTag>
        </metaInformation>
        -->