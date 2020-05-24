In this extension we are going to try invoke a function present in content script from background script.

### `manfiest.json`
```json
{
    "name": "Invoker",
    "description": "This is an example on how to invoke content script from background script",
    "version": "0.0.0",
    "manifest_version": 2,
    "browser_action": {},
    "background": {
        "scripts": [
            "./background-scripts/first.js"
        ],
        "persistent": false
    },
    "content_scripts": [
        {
            "matches": [ "<all_urls>" ],
            "js": [ "./content-scripts/doSomething.js" ],
            "run_at": "document_idle",
            "all_frames": true
        }
    ],
    "permissions": [
        "activeTab"
    ]
}
```
background scripts run in the background and can react to events issued by browser or content scripts.
Content scripts are able to run in the context of the page, that is they can access the DOM, `all_frames` will let script to be run in iframes as well.