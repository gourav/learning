chrome.browserAction.onClicked.addListener( tab => {
    chrome.tabs.executeScript({
        code: 'doSomething()'
    });
});