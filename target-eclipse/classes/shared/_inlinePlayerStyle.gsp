<style type="text/css">
a.sm2_link {
 /* assume all items will be sounds rather than wait for onload etc. in this example.. may differ for your uses. */
 display:inline-block;
 padding-left:22px;
 min-height:16px;
 border:3px solid #666;
 background:#666 url('<g:createLinkTo dir="${pContextPath}/images" file="icon_play.png" />') no-repeat 0px 50%;
 -moz-border-radius:3px;
 -webkit-border-radius:3px;
 border-radius:3px;
 padding:0px 3px 0px 20px;
 text-decoration:none;
 font-weight:bold;
 color:#fff;
 text-shadow: 0 0 0 #000; /* stupid Safari "fat" font rendering tweak */
}

a.sm2_link {
 /* safari 3.1+ fun (or, proprietary crap. TBD.) */
 -webkit-transition-property: hover;
 -webkit-transition: all 0.15s ease-in-out;
}

a.sm2_paused:hover,
a.sm2_link:hover {
 background:#333 url('<g:createLinkTo dir="${pContextPath}/images" file="icon_play.png" />') no-repeat 0px 50%;
 _background-image:url('<g:createLinkTo dir="${pContextPath}/images" file="icon_play.gif" />'); /* IE 6 */
 border-color:#333;
}

a.sm2_paused {
 background-color:#999;
 border-color:#999;
}

a.sm2_paused:hover {
 background:#999 url('<g:createLinkTo dir="${pContextPath}/images" file="icon_play.png" />') no-repeat 0px 50%;
 _background-image:url('<g:createLinkTo dir="${pContextPath}/images" file="icon_play.gif" />');
 border-color:#999;
}

a.sm2_playing,
a.sm2_playing:hover {
 background:#336699 url('<g:createLinkTo dir="${pContextPath}/images" file="icon_pause.png" />') no-repeat 0px 50%;
 _background-image:url('<g:createLinkTo dir="${pContextPath}/images" file="icon_pause.gif" />');
 border-color:#336699;
 text-decoration:none;
}
</style>