<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- Page styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.1.3/material.min.css">
<link rel="stylesheet" href="styles.css">
<style type="text/css">
body {
	margin: 0;
}

/* Disable ugly boxes around images in IE10 */
a img {
	border: 0px;
}

::-moz-selection {
	background-color: #6ab344;
	color: #fff;
}

::selection {
	background-color: #6ab344;
	color: #fff;
}

.android-search-box .mdl-textfield__input {
	color: rgba(0, 0, 0, 0.87);
}

.android-header .mdl-menu__container {
	z-index: 50;
	margin: 0 !important;
}

.mdl-textfield--expandable {
	width: auto;
}

.android-fab {
	position: absolute;
	right: 20%;
	bottom: -26px;
	z-index: 3;
	background: #64ffda !important;
	color: black !important;
}

.android-mobile-title {
	display: none !important;
}

.android-logo-image {
	height: 145px;
	width: 200px;
}

.android-header {
	overflow: visible;
	background-color: white;
}

.android-header .material-icons {
	color: #767777 !important;
}

.android-header .mdl-layout__drawer-button {
	background: transparent;
	color: #767777;
}

.android-header .mdl-navigation__link {
	color: #757575;
	font-weight: 700;
	font-size: 14px;
}

.android-navigation-container {
	/* Simple hack to make the overflow happen to the left instead... */
	direction: rtl;
	-webkit-order: 1;
	-ms-flex-order: 1;
	order: 1;
	width: 500px;
	transition: opacity 0.2s cubic-bezier(0.4, 0, 0.2, 1), width 0.2s
		cubic-bezier(0.4, 0, 0.2, 1);
}

.android-navigation {
	/* ... and now make sure the content is actually LTR */
	direction: ltr;
	-webkit-justify-content: flex-end;
	-ms-flex-pack: end;
	justify-content: flex-end;
	width: 800px;
}

.android-search-box.is-focused+.android-navigation-container {
	opacity: 0;
	width: 100px;
}

.android-navigation .mdl-navigation__link {
	display: inline-block;
	height: 60px;
	line-height: 68px;
	background-color: transparent !important;
	border-bottom: 4px solid transparent;
}

.android-navigation .mdl-navigation__link:hover {
	border-bottom: 4px solid #8bc34a;
}

.android-search-box {
	-webkit-order: 2;
	-ms-flex-order: 2;
	order: 2;
	margin-left: 16px;
	margin-right: 16px;
}

.android-more-button {
	-webkit-order: 3;
	-ms-flex-order: 3;
	order: 3;
}

.android-drawer {
	border-right: none;
}

.android-drawer-separator {
	height: 1px;
	background-color: #dcdcdc;
	margin: 8px 0;
}

.android-drawer .mdl-navigation__link.mdl-navigation__link {
	font-size: 14px;
	color: #757575;
}

.android-drawer span.mdl-navigation__link.mdl-navigation__link {
	color: #8bc34a;
}

.android-drawer .mdl-layout-title {
	position: relative;
	background: #6ab344;
	height: 160px;
}

.android-be-together-section {
	position: relative;
	height: 800px;
	width: auto;
	background-color: #f3f3f3;
	background: url('images/slide01.jpg') center 30% no-repeat;
	background-size: cover;
}

.logo-font {
	font-family: 'Roboto', 'Helvetica', 'Arial', sans-serif;
	line-height: 1;
	color: #767777;
	font-weight: 500;
}

.android-slogan {
	font-size: 60px;
	padding-top: 160px;
}

.android-sub-slogan {
	font-size: 21px;
	padding-top: 24px;
}

.android-create-character {
	font-size: 21px;
	padding-top: 200px;
}

.android-screen-section {
	position: relative;
	padding-top: 60px;
	padding-bottom: 80px;
}

.android-screens {
	text-align: right;
	width: 100%;
	white-space: nowrap;
	overflow-x: auto;
}

.android-screen {
	text-align: center;
}

.android-screen .android-link {
	margin-top: 16px;
	display: block;
	z-index: 2;
}

.android-image-link {
	text-decoration: none;
}

.android-wear {
	display: inline-block;
	width: 160px;
	margin-right: 32px;
}

.android-wear .android-screen-image {
	width: 40%;
	z-index: 1;
}

.android-wear-section {
	position: relative;
	background: url('images/wear.png') center top no-repeat;
	background-size: cover;
	height: 800px;
}

.android-wear-band {
	position: absolute;
	bottom: 0;
	width: 100%;
	text-align: center;
	background-color: #37474f;
}

.android-wear-band-text {
	max-width: 800px;
	margin-left: 25%;
	padding: 24px;
	text-align: left;
	color: white;
}

.android-wear-band-text p {
	padding-top: 8px;
}

.android-link {
	text-decoration: none;
	color: #8bc34a !important;
}

.android-link:hover {
	color: #7cb342 !important;
}

.android-link .material-icons {
	position: relative;
	top: -1px;
	vertical-align: middle;
}

.android-alt-link {
	text-decoration: none;
	color: #64ffda !important;
	font-size: 16px;
}

.android-alt-link:hover {
	color: #00bfa5 !important;
}

.android-alt-link .material-icons {
	position: relative;
	top: 6px;
}

.android-customized-section {
	text-align: center;
}

.android-customized-section-text {
	max-width: 500px;
	margin-left: auto;
	margin-right: auto;
	padding: 80px 16px 0 16px;
}

.android-customized-section-text p {
	padding-top: 16px;
}

.android-customized-section-image {
	background: url('images/devices.jpg') center top no-repeat;
	background-size: cover;
	height: 400px;
}

.android-more-section {
	padding: 80px 0;
	max-width: 1044px;
	margin-left: auto;
	margin-right: auto;
}

.android-more-section .android-section-title {
	margin-left: 12px;
	padding-bottom: 24px;
}

.android-card-container {
	
}

.android-card-container .mdl-card__media {
	overflow: hidden;
	background: transparent;
}

.android-card-container .mdl-card__media img {
	width: 100%;
}

.android-card-container .mdl-card__title {
	background: transparent;
	height: auto;
}

.android-card-container .mdl-card__title-text {
	color: black;
	height: auto;
}

.android-card-container .mdl-card__supporting-text {
	height: auto;
	color: black;
	padding-bottom: 56px;
}

.android-card-container .mdl-card__actions {
	position: absolute;
	bottom: 0;
}

.android-card-container .mdl-card__actions a {
	border-top: none;
	font-size: 16px;
}

/**** Mobile layout ****/
@media ( max-width : 700px) {
	.android-navigation-container {
		display: none;
	}
	.android-title {
		display: none !important;
	}
	.android-mobile-title {
		display: block !important;
		position: absolute;
		left: calc(50% - 70px);
		top: 12px;
		transition: opacity 0.2s cubic-bezier(0.4, 0, 0.2, 1);
	}

	/* WebViews in iOS 9 break the "~" operator, and WebViews in OS X 10.10 break
     consecutive "+" operators in some cases. Therefore, we need to use both
     here to cover all the bases. */
	.android.android-search-box.is-focused ~ .android-mobile-title,
		.android-search-box.is-focused+.android-navigation-container+.android-mobile-title
		{
		opacity: 0;
	}
	.android-more-button {
		display: none;
	}
	.android-search-box.is-focused {
		width: calc(100% - 48px);
	}
	.android-search-box .mdl-textfield__expandable-holder {
		width: 100%;
	}
	.android-be-together-section {
		height: 350px;
	}
	.android-slogan {
		font-size: 26px;
		margin: 0 16px;
		padding-top: 24px;
	}
	.android-sub-slogan {
		font-size: 16px;
		margin: 0 16px;
		padding-top: 8px;
	}
	.android-create-character {
		padding-top: 200px;
		font-size: 16px;
	}
	.android-create-character img {
		height: 12px;
	}
	.android-fab {
		display: none;
	}
	.android-wear-band-text {
		margin-left: 0;
		padding: 16px;
	}
	.android-footer .mdl-mega-footer--bottom-section {
		display: none;
	}
}
</style>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<div class="android-navigation-container">
			
		</div>
		<div
			class="android-header mdl-layout__header mdl-layout__header--waterfall">
			<div class="mdl-layout__header-row">
				<!-- Add spacer, to align navigation to the right in desktop -->
				<div class="android-header-spacer mdl-layout-spacer"></div>
				<div
					class="android-search-box mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right mdl-textfield--full-width">
					<label class="mdl-button mdl-js-button mdl-button--icon"
						for="search-field"> <i class="material-icons">search</i>
					</label>
					<div class="mdl-textfield__expandable-holder">
						<input class="mdl-textfield__input" type="text" id="search-field">
					</div>
				</div>

				<!-- Navigation -->
				<div class="android-navigation-container">
					<nav class="android-navigation mdl-navigation">
						<a class="mdl-navigation__link mdl-typography--text-uppercase"
							class="mdl-navigation__link mdl-typography--text-uppercase"
							href="">Console</a> 
							
							
							<form  name='GoogleSocialloginForm'
				action="<c:url value='../auth/google' />" method='POST'>
				<button class="mdl-navigation__link mdl-typography--text-uppercase" 	>Sign-In
				<input type="hidden" name="scope"
					value="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www-opensocial.googleusercontent.com/api/people https://www.googleapis.com/auth/plus.login" />
					</form>
					</nav>
				</div>

				<button
					class="android-more-button mdl-button mdl-js-button mdl-button--icon mdl-js-ripple-effect"
					id="more-button">
					<i class="material-icons">more_vert</i>
				</button>
				<ul
					class="mdl-menu mdl-js-menu mdl-menu--bottom-right mdl-js-ripple-effect"
					for="more-button">
					<li class="mdl-menu__item">1.8 Mboss_BL</li>
					<li class="mdl-menu__item">1.3 Mboss_BL</li>
					<li disabled class="mdl-menu__item">1.2 Mboss_BL</li>
					<li class="mdl-menu__item">MBoss History</li>
				</ul>
			</div>
		</div>
		<div class="android-content mdl-layout__content">
			<a name="top"></a>
			<div class="android-be-together-section mdl-typography--text-center">
				<div class="logo-font android-slogan">MBASS</div>
				<div class="logo-font android-sub-slogan">MBass (Mobile
					Backend as a service) BridgeLabz is a cloud services provider and
					backend as a service company based in Mumbai</div>
			</div>
		</div>
	</div>
	<a href="" target="" id="view-source"
		class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast">BridgeLabz</a>
	<script src="https://code.getmdl.io/1.1.3/material.min.js"></script>

</body>
</html>
