<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />
<jsp:useBean id="suggestSubmitType" scope="session" class="fr.paris.lutece.plugins.suggest.web.SuggestSubmitTypeJspBean" />
<% suggestSubmitType.init( request, fr.paris.lutece.plugins.suggest.web.ManageSuggestJspBean.RIGHT_MANAGE_SUGGEST_LIKE); %>
<%= suggestSubmitType.getModifySuggestSubmitType( request ) %>
<%@ include file="../../AdminFooter.jsp" %>