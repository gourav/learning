In this extension, we are going to try to send message from content script to the background page. Building on experience gained by other extensions, to send message from content script to background page.

```javascript
chrome.runtime.sendMessage( payload, ( response ) => {
    console.log( 'Last Name is' + response );
});
```

And to react to message.
```javascript
chrome.runtime.onMessage.addListener(
    ( request, sender, sendResponse ) => {
        sendResponse( 'Tiwari' );
    }
)
```

where `sendResponse` is the function we can use to send some response back to the script.