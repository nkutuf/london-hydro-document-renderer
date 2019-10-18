<?xml version="1.0"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:s="http://www.stylusstudio.com/xquery">
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
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:text>Mailing address</xsl:text>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="/Letter/MailingAddress"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:text>customer name</xsl:text>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="/Letter/MailingAddress/CustomerName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:text>Account Number</xsl:text>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="/Letter/AccountData/AccountNumber"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <fo:block>
                                                    <xsl:text>&#xA0;</xsl:text>
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:text>first name</xsl:text>
                                                </fo:block>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="/Letter/AccountData/FirstName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:text>last name</xsl:text>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="/Letter/AccountData/LastName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                            <fo:table width="100%" border-style="outset" border-width="2pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="2pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
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