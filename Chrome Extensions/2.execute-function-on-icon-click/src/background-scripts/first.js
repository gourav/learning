chrome.browserAction.onClicked.addListener(
    ( tab ) => {
        alert( 'I am reacting to click on browser extension icon.' );
    }
);