Let's say that we want to have a chrome extension that does not shows a pop when user clicks on the extension icon.
Instead, we want a function to be executed.

### Background Scripts
Background scripts are usually created for long running taks and can react to differente events.
One of such events is `chrome.browserAction.onClicked` which is only fired if there is no `default_action` described in the `manifest.json` file.

```json
{
    "name": "Hello Execute",
    "description": "This is a test as to how to execute a function when extension icon is cliked on browswer.",
    "version": "0.0.1",
    "manifest_version": 2,
    "browser_action": {},
    "background": {
        "scripts": [
            "./background-scripts/first.js"
        ],
        "persistent": false
    }
}
```
> It's important that you do't miss `"browser_action": {},` otherwise chrome will refuse to execute code.