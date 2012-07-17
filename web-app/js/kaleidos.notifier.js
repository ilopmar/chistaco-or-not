/* Kaleidos Notifier.js 
 *
 * Copyright (c) 2011 Kaleidos <hello@kaleidos.net>
 * Copyright (c) 2011 Andrei Antoukh <niwi@niwi.be>
 *
 * Dual licensed under the MIT or GPL Version 2 licenses.
*/

(function($){
    var defaults = {
        defaultTimeOut: 5000,
        notificationStyles: {
            padding: "12px 18px",
            margin: "0 0 6px 0",
            backgroundColor: "#000",
            opacity: 0.8,
            color: "#fff",
            font: "normal 13px 'Droid Sans', sans-serif",
            borderRadius: "3px",
            boxShadow: "#999 0 0 12px",
            width: "300px"
        },
        notificationStylesHover: {
            opacity: 1,
            boxShadow: "#000 0 0 12px"
        },
        container: $("<div></div>"),
        containerElement: function(message, title, iconUrl) {
            var self = this;
            var element = $("<div />").css(this.notificationStyles);

            element.hover(
                function() { $(this).css(self.notificationStylesHover); },
                function() { $(this).css(self.notificationStyles); }
            );

            var text_element_dom = $("<div />");
            text_element_dom.css({
                'display': 'inline-block',
                'verticalAlign': 'middle',
                'padding': '0 12px'
            });

            /* TODO: handle iconUrl */

            if (title !== undefined) {
                var title_element_dom = $("<div />");
                title_element_dom.html(title);
                title_element_dom.css({'font-weight': 'bold'});
                text_element_dom.append(title_element_dom);
            }

            if (message !== undefined) {
                var message_element_dom = $("<div />");
                message_element_dom.html(message);
                text_element_dom.append(message_element_dom);
            }
            element.append(text_element_dom);
            return element;
        },
        containerStyles: {
            "position": "fixed",
            "z-index": 9999,
            "top": "12px",
            "right": "12px"
        },
        defaultClickElement: function(notify_dom_element) {
            notify_dom_element.hide();
        },
        defaultFadeOut: function(notify_dom_element) {
            notify_dom_element.remove();
        },
        defaultData: {
            info: {
                iconurl: undefined,
                title: "Info"
            },
            message: {
                iconurl: undefined,
                title: undefined,
            }
        },
        defaultContainerId: 'kaleidos-notifier'
    };

    var Notifier = function(params) {
        if (params === undefined) {
            params = {};
        }

        this.options = $.extend({}, defaults, params);
        this.container = $(this.options.container).clone();
        this.container.css(this.options.containerStyles);
        this.container.attr('id', this.options.defaultContainerId);
        var self = this;

        $(document).ready(function() {
            var current_notifier = $(document).data('kaleidos-notifier');
            if (current_notifier !== undefined) {
                current_notifier.remove();
            }
            $(document).data('kaleidos-notifier', self);
            $("body").prepend(self.container);
        });
    };

    Notifier.prototype.notify = function(message, title, iconurl, timeout) {
        var notify_element = this.options.containerElement(message, title, iconurl);
        var timeout = timeout || this.options.defaultTimeOut;
        var self = this;

        if (timeout > 0) {
            notify_element.delay(timeout).fadeOut(function() {
                self.options.defaultFadeOut(notify_element);
            });
        }
        
        notify_element.bind('click', function() {
            self.options.defaultClickElement(notify_element);
        });

        this.container.prepend(notify_element);
    };
    
    Notifier.prototype.message = function(message, title, timeout) {
        var default_message_icon = this.options.defaultData.message.iconurl;
        var default_title = title || this.options.defaultData.message.title;
        this.notify(message, default_title, default_message_icon, timeout);
    };

    Notifier.prototype.remove = function() {
        this.container.remove();
    };
    
    $.knotifyConfigure = function(params) {
        var notify = $.knotify = new Notifier(params);
        return notify;
    };
    $.knotify = new Notifier();
})(jQuery);
