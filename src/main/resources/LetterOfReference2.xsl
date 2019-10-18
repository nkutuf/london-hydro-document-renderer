<?xml version="1.0"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:filecopy="xalan://com.londonhydro.billimaging.transformation.DocumentImageModel" xmlns:s="http://www.stylusstudio.com/xquery">
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
                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                       
												<xsl:variable name="currentDate" select="/BatchLetters/Letter/CurrentDate"/>
												date: <xsl:value-of select="$currentDate[4]"/>
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
                            <xsl:text>&#xA0;</xsl:text>
                        </fo:block>
                        <fo:block>
                            <fo:table width="100%" border-style="outset" border-width="0pt" background-repeat="repeat">
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-column/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
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

												<xsl:variable name="mailingAddress" select="/BatchLetters/Letter/MailingAddress"/>
												Mailing Address: <xsl:value-of select="$mailingAddress[4]"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:text>&#xA0;</xsl:text>
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
                            <xsl:text>&#xA0;</xsl:text>
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
                                                <xsl:value-of select="filecopy:getSubject()"/> <xsl:variable name="accountNumber" select="/BatchLetters/Letter/AccountData/AccountNumber"/>
												    Account Number: <xsl:value-of select="$accountNumber[4]"/>
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
                            <xsl:text>&#xA0;</xsl:text>
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA0;</xsl:text>
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
                                            <xsl:value-of select="filecopy:getFirstParagraph()"/>
                                            </fo:block>

                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="filecopy:getSecondParagraph()"/>
                                            </fo:block>

                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="filecopy:getThirdParagraph()"/>
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
                            <xsl:text>&#xA0;</xsl:text>
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
                                                <fo:block>
                                                    
													<xsl:variable name="accountNumber" select="/BatchLetters/Letter/AccountData/AccountNumber"/>
												Account Number: <xsl:value-of select="$accountNumber[4]"/>
                                                </fo:block>
                                                <fo:block>
                                                Customer Name    <xsl:variable name="firstName" select="/BatchLetters/Letter/AccountData/FirstName"/>
											
												    <xsl:value-of select="$firstName[4]"/>,
									            
												    <xsl:variable name="lastName" select="/BatchLetters/Letter/AccountData/LastName"/>
                                                    <xsl:value-of select="$lastName[4]"/>
			
                                                </fo:block>


                                                <fo:block>
                                                    <xsl:text>&#xA0;</xsl:text>
                                                </fo:block>
                                                <fo:block>
													Service Adress: <xsl:variable name="serviceAddress" select="/BatchLetters/Letter/ServiceAddress"/>
												    <xsl:value-of select="$serviceAddress[4]"/>
                                                </fo:block>

                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block/>
                                        </fo:table-cell>
                                        <fo:table-cell border-style="inset" border-width="0pt" padding="2pt" background-repeat="repeat" display-align="center">
                                            <fo:block>
                                                <xsl:value-of select="filecopy:getFourthParagraph()"/>
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
  
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA0;</xsl:text>
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA0;</xsl:text>
                        <fo:block>
                            <xsl:value-of select="/BatchLetters/Letter/MoveData"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/BatchLetters/Letter/EBTData"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/BatchLetters/Letter/FICAData"/>
   
                        </fo:block>                        </fo:block>

                        <fo:block>
                            <xsl:text>&#xA0;</xsl:text>
                        </fo:block>
                   
                        
                     
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2009. Progress Software Corporation. All rights reserved.

<metaInformation>
	<scenarios>
		<scenario default="yes" name="Scenario1" userelativepaths="yes" externalpreview="no" url="SAP_20190924000001_batchletters.xml" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="yes" profilemode="0" profiledepth="" profilelength=""
		          urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="renderx" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal"
		          customvalidator="">
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
		<MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/>
		<MapperBlockPosition></MapperBlockPosition>
		<TemplateContext></TemplateContext>
		<MapperFilter side="source"></MapperFilter>
	</MapperMetaTag>
</metaInformation>
-->