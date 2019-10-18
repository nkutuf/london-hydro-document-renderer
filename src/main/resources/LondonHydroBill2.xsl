<?xml version="1.0"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:filecopy="xalan://com.londonhydro.billimaging.transformation.DocumentImageModel"
                exclude-result-prefixes="filecopy" xmlns:s="http://www.stylusstudio.com/xquery" xmlns:n01="http://londonhydro.com/Matrix/BILL/BillPrint">
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
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <fo:block color="red" font-size="8pt">
                                                        <fo:external-graphic background="transparent" width="50pt" content-width="scale-to-fit" height="80pt" content-height="scale-to-fit" scaling="non-uniform" src="url(file:///c:/Users/defaultuser0/Downloads/LondonHydroLogoColor.svg)"/>

                                                        Buyy:<xsl:value-of select="filecopy:getSubject()"/>
                                                        111 GodHorton St
                                                        P.O.Box 3060
                                                        London ON N6A 4JB forestloss
                                                        <xsl:value-of select="filecopy:getThirdParagraph()"/>
                                                        last: <xsl:value-of select="filecopy:getFullNames()"/> fisrt
                                                        <xsl:variable name="user" select="filecopy:getAddressOne()" />
                                                        $userx  <xsl:value-of select="$user" />

                                                        <fo:block/>
                                                        <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@InvoiceNumber"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/MailingAddress"/>
                                                    </fo:block>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <fo:block>
                                                        <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                                            <fo:table-column/>
                                                            <fo:table-column/>
                                                            <fo:table-column/>
                                                            <fo:table-body>
                                                                <fo:table-row>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                        <fo:block>
                                                                            <xsl:text>Billing Number:</xsl:text>
                                                                        </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                        <fo:block>
                                                                            <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@ContractAccount"/>
                                                                        </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                        <fo:block/>
                                                                    </fo:table-cell>
                                                                </fo:table-row>
                                                            </fo:table-body>
                                                        </fo:table>
                                                    </fo:block>
                                                    <fo:block>
                                                        <fo:block>
                                                            <xsl:text>  Please use the billing number above when paying online.</xsl:text>
                                                        </fo:block>
                                                        <fo:block>
                                                            <xsl:text> This bill may be paid at most financial instituitions</xsl:text>
                                                        </fo:block>
                                                        <fo:block>
                                                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                                                <fo:table-column/>
                                                                <fo:table-column/>


                                                                <fo:table-body>
                                                                    <fo:table-row>
                                                                        <fo:table-cell background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                            <fo:block>
                                                                                <xsl:text>Billing </xsl:text>
                                                                                <fo:inline>
                                                                                    <xsl:text>Date</xsl:text>
                                                                                </fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                            <fo:block>
                                                                                <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/@date"/>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                            <fo:block>
                                                                                <xsl:text>Total Amount Due</xsl:text>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                            <fo:block>
                                                                                <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                                                <xsl:value-of select="$summaryItem[5]"/>

                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell  background-color="#808080" border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                                            <fo:block>
                                                                                <xsl:text>Due Date</xsl:text>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <fo:table-cell border-style="inset" border-width="1pt" padding="2pt" background-repeat="repeat" display-align="center">
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
                                                            <xsl:text>Interest charges of 1.5% per month (19.56% per year) will be applied on all over dues charges</xsl:text>
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
                                <xsl:text>&#xA0;</xsl:text>
                            </fo:block>
                            <fo:block>
                                <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/OCR"/>
                            </fo:block>
                            <fo:block>

                            </fo:block>
                            <fo:block>
                                <xsl:text>&#xA0;</xsl:text>
                            </fo:block>

                            <fo:block>
                                <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                    <fo:table-column/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell  background-color="#808080" border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">Bill Summary - Billing Number
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
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Previous Balance</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    $
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>

                                                    <xsl:value-of select="$summaryItem[9]"/>

                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:text>Billing Date</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/@date"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Total Payment since last bill&#xA0;&#xA0; </xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    $
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>

                                                    <xsl:value-of select="$summaryItem[8]"/>

                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:text>Customer Name</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/DisplayName"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Total Current Utility Charges</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>$</fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>


                                                    <xsl:value-of select="$summaryItem[10]"/>


                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:text>Customer Number</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/@CustomerNumber"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Budget Billing Amount</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    $
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>

                                                    <xsl:value-of select="$summaryItem[11]"/>

                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:text>Mailing Postal Code</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/CustomerInformation/MailingAddress/postal_code"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>(Total HST )</xsl:text>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    $
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[8]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block/>
                                            </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Total Amount Due</xsl:text>



                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    $
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[5]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
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
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block>
                                                    <xsl:text>Credit Balance</xsl:text>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:variable name="summaryItem" select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvSummary/SummaryItem/Value"/>
                                                    <xsl:value-of select="$summaryItem[6]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block/>
                                            </fo:table-cell>
                                            <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
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
                                            <fo:table-cell  background-color="#808080" border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                                <fo:block  font-weight="bold">
                                                    <xsl:value-of select="$DefaultDocument/n01:MT_BillPrint/invextract/invdoc/InvDetails/Service/@Premise[1]"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>

                            <fo:block>
                            <!--this bblock does not work properly-->


                            <!--end of this block does not work properly-->

                            </fo:block>
                        </fo:block>

                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell  border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block  font-weight="bold">
                                                Terms on your statement
                                            </fo:block>
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
                                        <fo:table-cell  border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                Electricity: This is the cost of the electricity supplied to you during this billing period and is the part of the bill that is subject to competition.
                                                Delivery: These are the costs of delivering electricity from generating
                                                stations across the province to London Hydro, then to your home or business. This includes the costs to build and maintain the transmission
                                                and distribution lines, towers and poles and operate provincial and local electricity systems.
                                                A portion of these charges are fixed and do not change from month to month. The rest are variable and increase or decrease depending on the
                                                amount of electricity that you use.
                                                The delivery charge also includes costs related to electricity lost through
                                                distributing electricity to your home or business.* London Hydro collects
                                                this money and pays this amount directly to our suppliers.

                                                * When electricity is delivered over a power line, it is normal for a small amount of power to be consumed or lost as heat. Equipment, such as wires and transformers, consumes power before it gets to your home or business.
                                                Regulatory Charges: Regulatory Charges are the costs of administering the wholesale electricity system and maintaining the reliability of the provincial
                                                grid.
                                                Global Adjustment: Electricity generators in Ontario receive a combination of payments from the operation of the wholesale market, payments set by
                                                regulation and payments under contracts. Your portion of the net adjustments arising from these and other authorized payments is included
                                                on your bill as the Global Adjustment.
                                                Note: For a detailed explanation of electricity terms, please visit
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