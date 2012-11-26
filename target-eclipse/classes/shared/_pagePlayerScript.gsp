<script type="text/javascript" 
 src="<g:createLinkTo dir="${pContextPath}/js" file="pagePlayer-min.js" />" >
</script>
<script type="text/javascript">
soundManager.debugMode = false; 
soundManager.useConsole = false;
soundManager.url = '<g:createLinkTo dir="${pContextPath}/media" />'; 
var pagePlayer = new PagePlayer(typeof PP_CONFIG != 'undefined'?PP_CONFIG:null);
soundManager.onload = function() {
  pagePlayer.initDOM();
}

</script>