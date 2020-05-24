chrome.browserAction.onClicked.addListener( tab => {
    alert( 'I reacted' );
});

/**
 * What to do when receive a message from the cotnent script.
 */
chrome.runtime.onMessage.addListener(
    ( request, sender, sendResponse ) => {
        sendResponse( 'Tiwari' );
    }
)