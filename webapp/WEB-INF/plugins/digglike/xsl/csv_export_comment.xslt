<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	<xsl:template match="/digg">
		<xsl:text>"commentaire";"date du commentaire";"type de commentaire";"proposition comment&#233;e";"date proposition";"score";"nombre de vote";"nombre de commentaire";"cat&#233;gorie"</xsl:text>
		<xsl:text>&#10;</xsl:text>
		<xsl:apply-templates select="diggs-submit/digg-submit"/>
	</xsl:template>
	<xsl:template match="/digg/diggs-submit/digg-submit">
	
	<xsl:for-each select="diggs-submit-comments/digg-submit-comment">
	
				<xsl:text>"</xsl:text><xsl:value-of select="digg-submit-comment-value"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="digg-submit-comment-date"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"commentaire de proposition"</xsl:text><xsl:text>;</xsl:text>
				
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-value"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-date-response"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-score"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-number-vote"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-number-comment"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
				<xsl:text>"</xsl:text><xsl:value-of select="../../digg-submit-category"/><xsl:text>"</xsl:text> <xsl:text>&#10;</xsl:text>
				<xsl:for-each select="diggs-submit-comments/digg-submit-comment">
					<xsl:text>"</xsl:text><xsl:value-of select="digg-submit-comment-value"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="digg-submit-comment-date"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"commentaire de commentaire"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-value"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-date-response"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-score"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-number-vote"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-number-comment"/><xsl:text>"</xsl:text><xsl:text>;</xsl:text>
					<xsl:text>"</xsl:text><xsl:value-of select="../../../../digg-submit-category"/><xsl:text>"</xsl:text> <xsl:text>&#10;</xsl:text>
				</xsl:for-each >
	</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>