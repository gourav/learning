const payload = { name: "Gaurav" };
chrome.runtime.sendMessage( payload, ( response ) => {
    console.log( 'Last Name is' + response );
});