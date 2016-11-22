package com.example.umair.servlet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
//        updating activity title
        this.setTitle(getIntent().getStringExtra("title").toString());

//        adding dummy HTML
        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String data = " <HEAD>\n" +
                "<TITLE>Basic HTML Sample Page</TITLE>\n" +
                "</HEAD>\n" +
                "\n" +
                "<BODY BGCOLOR=\"WHITE\">\n" +
                "<CENTER>\n" +
                "<H1>A Simple Sample Web Page</H1>\n" +
                "\n" +
                " \n" +
                "\n" +
                "  <IMG SRC=\"http://sheldonbrown.com/images/scb_eagle_contact.jpeg\">\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "  <H4>By Sheldon Brown</H4>\n" +
                "\n" +
                "<H2>Demonstrating a few HTML features</H2>\n" +
                "\n" +
                "</CENTER>\n" +
                "\n" +
                "HTML is really a very simple language. It consists of ordinary text, with commands that are enclosed by \"<\" and \">\" characters, or bewteen an \"&\" and a \";\". <P>\n" +
                " \n" +
                "\n" +
                "You don't really need to know much HTML to create a page, because you can copy bits of HTML from other pages that do what you want, then change the text!<P>\n" +
                " \n" +
                "\n" +
                "This page shows on the left as it appears in your browser, and the corresponding HTML code appears on the right. The HTML commands are linked to explanations of what they do.\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "<H3>Line Breaks</H3>\n" +
                "\n" +
                "HTML doesn't normally use line breaks for ordinary text. A white space of any size is treated as a single space. This is because the author of the page has no way of knowing the size of the reader's screen, or what size type they will have their browser set for.<P>\n" +
                "\n" +
                " \n" +
                "\n" +
                "If you want to put a line break at a particular place, you can use the \"<BR>\" command, or, for a paragraph break, the \"<P>\" command, which will insert a blank line. The heading command (\"<4></4>\") puts a blank line above and below the heading text.\n" +
                "\n" +
                " \n" +
                "\n" +
                "<H4>Starting and Stopping Commands</H4>\n" +
                "\n" +
                "Most HTML commands come in pairs: for example, \"<H4>\" marks the beginning of a size 4 heading, and \"</H4>\" marks the end of it. The closing command is always the same as the opening command, except for the addition of the \"/\".<P>\n" +
                "\n" +
                " \n" +
                "\n" +
                "Modifiers are sometimes included along with the basic command, inside the opening command's < >. The modifier does not need to be repeated in the closing command.\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "<H1>This is a size \"1\" heading</H1>\n" +
                "\n" +
                "<H2>This is a size \"2\" heading</H2>\n" +
                "\n" +
                "<H3>This is a size \"3\" heading</H3>\n" +
                "\n" +
                "<H4>This is a size \"4\" heading</H4>\n" +
                "\n" +
                "<H5>This is a size \"5\" heading</H5>\n" +
                "\n" +
                "<H6>This is a size \"6\" heading</H6>\n" +
                "\n" +
                "<center>\n" +
                "\n" +
                "<H4>Copyright © 1997, by\n" +
                "<A HREF=\"http://sheldonbrown.com/index.html\">Sheldon Brown</A>\n" +
                "</H4>\n" +
                "\n" +
                "If you would like to make a link or bookmark to this page, the URL is:<BR> http://sheldonbrown.com/web_sample1.html</body> ";


        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://localhost/test/test.html");
        myWebView.loadData(data,"text/html; charset=utf-8", null);


    }
}
