<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:import href="Styles.xsl"/>

    <fo:table xsl:use-attribute-sets="CustomStyles" margin-bottom=".1in" text-align="center" table-layout="fixed" width="100%">
        <fo:table-column column-width="proportional-column-width(100)"/>
        <fo:table-body width="100%" table-layout="fixed">
            <fo:table-row>
                <fo:table-cell text-align="center" padding-top=".5mm" padding-bottom=".5mm">
                    <fo:block>Some text is placed here.</fo:block>
                </fo:table-cell>
            </fo:table-row>
        </fo:table-body>
    </fo:table>
</xsl:stylesheet>