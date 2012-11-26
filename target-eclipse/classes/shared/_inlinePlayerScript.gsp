<script type="text/javascript" 
 src="<g:createLinkTo dir="${pContextPath}/js" file="inlineplayer-min.js" />" >
</script>
<script type="text/javascript">
var inlinePlayer = null;
soundManager.debugMode = false; 
soundManager.useConsole = false;
soundManager.url = '<g:createLinkTo dir="${pContextPath}/media" />'; 
soundManager.onload = function() {
 inlinePlayer = new InlinePlayer();
}
</script>