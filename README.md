ParseQueryAdapterWithPositions
==============================

Example Android app that passes positions along to the view for Parse with the ParseQueryAdapter

You'll need to go into MainApplication.java and edit the Parse initialization to add your own Parse keys to try the app out.

It creates a Parse class named Item, and colors alternating rows dark grey or white.

The ParseItemPositionQueryAdapter class initializes a ParseQueryAdapter, and then proxies calls to it, except for getView(), which is final in ParseQueryAdapter. That method calls an implementation of getItemView() that takes a position as the first argument. 
