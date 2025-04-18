package com.saleart.reporter.constant;

import com.saleart.reporter.util.ReportFreemarkerUtil;
import freemarker.template.Template;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReportConstant {

    public static final String PAGE_SIZE_ATTRIBUTE = "size";

    public static final String PAGE_TOP_MARGIN_ATTRIBUTE = "topMargin";

    public static final String PAGE_LEFT_MARGIN_ATTRIBUTE = "leftMargin";

    public static final String PAGE_RIGHT_MARGIN_ATTRIBUTE = "rightMargin";

    public static final String PAGE_BOTTOM_MARGIN_ATTRIBUTE = "bottomMargin";

    public static final String HEADER_TOP_MARGIN_ATTRIBUTE = "headerTopMargin";

    public static final String FOOTER_BOTTOM_MARGIN_ATTRIBUTE = "bottomTopMargin";

    public static final String CSS_PART_ATTRIBUTE = "cssPart";

    public static final String HEADER_PART_ATTRIBUTE = "headerPart";

    public static final String MAIN_PART_ATTRIBUTE = "mainPart";

    public static final String FOOTER_PART_ATTRIBUTE = "footerPart";

    public static final String FOOTER_PART_PAGE_ATTRIBUTE = "sayfaNumarasi";

    public static final String FOOTER_PART_PAGE_VALUE = "<span class='pageNumber'></span>";

    public static final String FREEMARKER_TR_SETTING = "<#setting locale=\"tr_TR\">\n";

    public static final String TEMPLATE_CSS = """
            :root{
            	--ck-color-mention-background:hsla(341, 100%, 30%, 0.1);
            	--ck-color-mention-text:hsl(341, 100%, 30%);
            }
            .ck-content .mention{
            	background:var(--ck-color-mention-background);
            	color:var(--ck-color-mention-text);
            }
            .ck-content code{
            	background-color:hsla(0, 0%, 78%, 0.3);
            	padding:.15em;
            	border-radius:2px;
            }
            .ck-content blockquote{
            	overflow:hidden;
            	padding-right:1.5em;
            	padding-left:1.5em;
            	margin-left:0;
            	margin-right:0;
            	font-style:italic;
            	border-left:solid 5px hsl(0, 0%, 80%);
            }
            .ck-content[dir="rtl"] blockquote{
            	border-left:0;
            	border-right:solid 5px hsl(0, 0%, 80%);
            }
            .ck-content pre{
            	padding:1em;
            	color:hsl(0, 0%, 20.8%);
            	background:hsla(0, 0%, 78%, 0.3);
            	border:1px solid hsl(0, 0%, 77%);
            	border-radius:2px;
            	text-align:left;
            	direction:ltr;
            	tab-size:4;
            	white-space:pre-wrap;
            	font-style:normal;
            	min-width:200px;
            }
            .ck-content pre code{
            		background:unset;
            		padding:0;
            		border-radius:0;
            	}
            .ck-content .text-tiny{
            		font-size:.7em;
            	}
            .ck-content .text-small{
            		font-size:.85em;
            	}
            .ck-content .text-big{
            		font-size:1.4em;
            	}
            .ck-content .text-huge{
            		font-size:1.8em;
            	}
            :root{
            	--ck-highlight-marker-yellow:hsl(60, 97%, 73%);
            	--ck-highlight-marker-green:hsl(120, 93%, 68%);
            	--ck-highlight-marker-pink:hsl(345, 96%, 73%);
            	--ck-highlight-marker-blue:hsl(201, 97%, 72%);
            	--ck-highlight-pen-red:hsl(0, 85%, 49%);
            	--ck-highlight-pen-green:hsl(112, 100%, 27%);
            }
            .ck-content .marker-yellow{
            		background-color:var(--ck-highlight-marker-yellow);
            	}
            .ck-content .marker-green{
            		background-color:var(--ck-highlight-marker-green);
            	}
            .ck-content .marker-pink{
            		background-color:var(--ck-highlight-marker-pink);
            	}
            .ck-content .marker-blue{
            		background-color:var(--ck-highlight-marker-blue);
            	}
            .ck-content .pen-red{
            		color:var(--ck-highlight-pen-red);
            		background-color:transparent;
            	}
            .ck-content .pen-green{
            		color:var(--ck-highlight-pen-green);
            		background-color:transparent;
            	}
            .ck-content hr{
            	margin:15px 0;
            	height:1px;
            	background:#000;
            	border:0;
            }
            :root{
            	--ck-color-image-caption-background:hsl(0, 0%, 97%);
            	--ck-color-image-caption-text:hsl(0, 0%, 20%);
            }
            .ck-content .image > figcaption{
            	display:table-caption;
            	caption-side:bottom;
            	word-break:break-word;
            	color:var(--ck-color-image-caption-text);
            	background-color:var(--ck-color-image-caption-background);
            	padding:.6em;
            	font-size:.75em;
            	outline-offset:-1px;
            }
            @media (forced-colors: active){
            .ck-content .image > figcaption{
            		background-color:unset;
            		color:unset;
            }
            	}
            .ck-content img.image_resized{
            	height:auto;
            }
            .ck-content .image.image_resized{
            	max-width:100%;
            	display:block;
            	box-sizing:border-box;
            }
            .ck-content .image.image_resized img{
            		width:100%;
            	}
            .ck-content .image.image_resized > figcaption{
            		display:block;
            	}
            :root{
            	--ck-image-style-spacing:1.5em;
            	--ck-inline-image-style-spacing:calc(var(--ck-image-style-spacing) / 2);
            }
            .ck-content .image.image-style-block-align-left,
            		.ck-content .image.image-style-block-align-right{
            			max-width:calc(100% - var(--ck-image-style-spacing));
            		}
            .ck-content .image.image-style-align-left,
            		.ck-content .image.image-style-align-right{
            			clear:none;
            		}
            .ck-content .image.image-style-side{
            			float:right;
            			margin-left:var(--ck-image-style-spacing);
            			max-width:50%;
            		}
            .ck-content .image.image-style-align-left{
            			float:left;
            			margin-right:var(--ck-image-style-spacing);
            		}
            .ck-content .image.image-style-align-right{
            			float:right;
            			margin-left:var(--ck-image-style-spacing);
            		}
            .ck-content .image.image-style-block-align-right{
            			margin-right:0;
            			margin-left:auto;
            		}
            .ck-content .image.image-style-block-align-left{
            			margin-left:0;
            			margin-right:auto;
            		}
            .ck-content .image-style-align-center{
            		margin-left:auto;
            		margin-right:auto;
            	}
            .ck-content .image-style-align-left{
            		float:left;
            		margin-right:var(--ck-image-style-spacing);
            	}
            .ck-content .image-style-align-right{
            		float:right;
            		margin-left:var(--ck-image-style-spacing);
            	}
            .ck-content p + .image.image-style-align-left,
            	.ck-content p + .image.image-style-align-right,
            	.ck-content p + .image.image-style-side{
            		margin-top:0;
            	}
            .ck-content .image-inline.image-style-align-left,
            		.ck-content .image-inline.image-style-align-right{
            			margin-top:var(--ck-inline-image-style-spacing);
            			margin-bottom:var(--ck-inline-image-style-spacing);
            		}
            .ck-content .image-inline.image-style-align-left{
            			margin-right:var(--ck-inline-image-style-spacing);
            		}
            .ck-content .image-inline.image-style-align-right{
            			margin-left:var(--ck-inline-image-style-spacing);
            		}
            .ck-content .image{
            		display:table;
            		clear:both;
            		text-align:center;
            		margin:0.9em auto;
            		min-width:50px;
            	}
            .ck-content .image img{
            			display:block;
            			margin:0 auto;
            			max-width:100%;
            			min-width:100%;
            			height:auto;
            		}
            .ck-content .image-inline{
            		display:inline-flex;
            		max-width:100%;
            		align-items:flex-start;
            	}
            .ck-content .image-inline picture{
            			display:flex;
            		}
            .ck-content .image-inline picture,
            		.ck-content .image-inline img{
            			flex-grow:1;
            			flex-shrink:1;
            			max-width:100%;
            		}
            .ck-content ol{
            	list-style-type:decimal;
            }
            .ck-content ol ol{
            		list-style-type:lower-latin;
            	}
            .ck-content ol ol ol{
            			list-style-type:lower-roman;
            		}
            .ck-content ol ol ol ol{
            				list-style-type:upper-latin;
            			}
            .ck-content ol ol ol ol ol{
            					list-style-type:upper-roman;
            				}
            .ck-content ul{
            	list-style-type:disc;
            }
            .ck-content ul ul{
            		list-style-type:circle;
            	}
            .ck-content ul ul ul{
            			list-style-type:square;
            		}
            .ck-content ul ul ul ul{
            				list-style-type:square;
            			}
            :root{
            	--ck-todo-list-checkmark-size:16px;
            }
            .ck-content .todo-list{
            	list-style:none;
            }
            .ck-content .todo-list li{
            		position:relative;
            		margin-bottom:5px;
            	}
            .ck-content .todo-list li .todo-list{
            			margin-top:5px;
            		}
            .ck-content .todo-list .todo-list__label > input{
            			-webkit-appearance:none;
            			display:inline-block;
            			position:relative;
            			width:var(--ck-todo-list-checkmark-size);
            			height:var(--ck-todo-list-checkmark-size);
            			vertical-align:middle;
            			border:0;
            			left:-25px;
            			margin-right:-15px;
            			right:0;
            			margin-left:0;
            		}
            .ck-content[dir=rtl] .todo-list .todo-list__label > input{
            		left:0;
            		margin-right:0;
            		right:-25px;
            		margin-left:-15px;
            		}
            .ck-content .todo-list .todo-list__label > input::before{
            		display:block;
            		position:absolute;
            		box-sizing:border-box;
            		content:'';
            		width:100%;
            		height:100%;
            		border:1px solid hsl(0, 0%, 20%);
            		border-radius:2px;
            		transition:250ms ease-in-out box-shadow;
            	}
            @media (prefers-reduced-motion: reduce){
            .ck-content .todo-list .todo-list__label > input::before{
            			transition:none;
            	}
            		}
            .ck-content .todo-list .todo-list__label > input::after{
            		display:block;
            		position:absolute;
            		box-sizing:content-box;
            		pointer-events:none;
            		content:'';
            		left:calc( var(--ck-todo-list-checkmark-size) / 3);
            		top:calc( var(--ck-todo-list-checkmark-size) / 5.3);
            		width:calc( var(--ck-todo-list-checkmark-size) / 5.3);
            		height:calc( var(--ck-todo-list-checkmark-size) / 2.6);
            		border-style:solid;
            		border-color:transparent;
            		border-width:0 calc( var(--ck-todo-list-checkmark-size) / 8) calc( var(--ck-todo-list-checkmark-size) / 8) 0;
            		transform:rotate(45deg);
            	}
            .ck-content .todo-list .todo-list__label > input[checked]::before{
            			background:hsl(126, 64%, 41%);
            			border-color:hsl(126, 64%, 41%);
            		}
            .ck-content .todo-list .todo-list__label > input[checked]::after{
            			border-color:hsl(0, 0%, 100%);
            		}
            .ck-content .todo-list .todo-list__label .todo-list__label__description{
            			vertical-align:middle;
            		}
            .ck-content .todo-list .todo-list__label.todo-list__label_without-description input[type=checkbox]{
            			position:absolute;
            		}
            .ck-content .media{
            	clear:both;
            	margin:0.9em 0;
            	display:block;
            	min-width:15em;
            }
            .ck-content .page-break{
            	position:relative;
            	clear:both;
            	padding:5px 0;
            	display:flex;
            	align-items:center;
            	justify-content:center;
            }
            .ck-content .page-break::after{
            		content:'';
            		position:absolute;
            		border-bottom:2px dashed hsl(0, 0%, 77%);
            		width:100%;
            	}
            .ck-content .page-break__label{
            	position:relative;
            	z-index:1;
            	padding:.3em .6em;
            	display:block;
            	text-transform:uppercase;
            	border:1px solid hsl(0, 0%, 77%);
            	border-radius:2px;
            	font-size:0.75em;
            	font-weight:bold;
            	color:hsl(0, 0%, 20%);
            	background:hsl(0, 0%, 100%);
            	box-shadow:2px 2px 1px hsla(0, 0%, 0%, 0.15);
            	-webkit-user-select:none;
            	-moz-user-select:none;
            	-ms-user-select:none;
            	user-select:none;
            }
            @media print{
            	.ck-content .page-break{
            		padding:0;
            	}
            
                .ck-content .page-break::after{
                    display:none;
                }
            }
            .ck-content .table{
            	margin:0.9em auto;
            	display:table;
            }
            .ck-content .table table{
            		border-collapse:collapse;
            		border-spacing:0;
            		width:100%;
            		height:100%;
            	}
            .ck-content .table table td,
            		.ck-content .table table th{
            			min-width:2em;
            			padding:.4em;
            		}
            .ck-content .table table th{
                font-weight:bold;
                background:rgba(0, 0, 0, 0.05);
            }
            .ck-content[dir="rtl"] .table th{
            	text-align:right;
            }
            .ck-content[dir="ltr"] .table th{
            	text-align:left;
            }
            :root{
            	--ck-color-selector-caption-background:hsl(0, 0%, 97%);
            	--ck-color-selector-caption-text:hsl(0, 0%, 20%);
            }
            .ck-content .table > figcaption{
            	display:table-caption;
            	caption-side:top;
            	word-break:break-word;
            	text-align:center;
            	color:var(--ck-color-selector-caption-text);
            	background-color:var(--ck-color-selector-caption-background);
            	padding:.6em;
            	font-size:.75em;
            	outline-offset:-1px;
            }
            @media (forced-colors: active){
            		.ck-content .table > figcaption{
            		background-color:unset;
            		color:unset;
            		}
            	}
            
            .ck-content .table .ck-table-resized{
            	table-layout:fixed;
            }
            .ck-content .table table{
            	overflow:hidden;
            }
            .ck-content .table td,
            .ck-content .table th{
            	overflow-wrap:break-word;
            	position:relative;
            }
            .ck-content{
            	font-family:Arial, Helvetica, sans-serif;
            }
            .ck-content .table table td, .ck-content .table table th {
                padding: 0;
                text-align: left;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
            .grid {
                width: 100%;
            }
            .gridCell {
                display: inline-block;
                box-sizing: border-box;
            }
            """;

    public static final Template TEMPLATE = ReportFreemarkerUtil.createTemplate(String.format("""
                    <html>
                        <head>
                            <meta charset="UTF-8"/>
                            <style>
                                body {
                                    font-family: 'Arial', sans-serif;
                                }
                                @page {
                                    size: ${%s};
                                    margin-top: ${%s};
                                    margin-left: ${%s};
                                    margin-right: ${%s};
                                    margin-bottom: ${%s};
                                    @top-center {
                                        text-align: left;
                                        vertical-align: top;
                                        margin-top: ${%s};
                                        content: element(header);
                                    }
                                    @bottom-center {
                                        text-align: left;
                                        vertical-align: top;
                                        margin-bottom: ${%s};
                                        content: element(footer);
                                    }
                                }
                                header {
                                    position: running(header);
                                }
                                footer {
                                    position: running(footer);
                                }
                                .pageNumber::before {
                                    content: counter(page) " / " counter(pages);
                                }
                                .table-page-break {
                                    page-break-after: always;
                                }
                                ${%s}
                            </style>
                        </head>
                        <body>
                             <header class="ck-content">
                                ${%s}
                             </header>
                             <footer class="ck-content">
                                ${%s}
                             </footer>
                             <main class="ck-content">
                                ${%s}
                             </main>
                        </body>
                    </html>
                    """,
            PAGE_SIZE_ATTRIBUTE,
            PAGE_TOP_MARGIN_ATTRIBUTE,
            PAGE_LEFT_MARGIN_ATTRIBUTE,
            PAGE_RIGHT_MARGIN_ATTRIBUTE,
            PAGE_BOTTOM_MARGIN_ATTRIBUTE,
            HEADER_TOP_MARGIN_ATTRIBUTE,
            FOOTER_BOTTOM_MARGIN_ATTRIBUTE,
            CSS_PART_ATTRIBUTE,
            HEADER_PART_ATTRIBUTE,
            FOOTER_PART_ATTRIBUTE,
            MAIN_PART_ATTRIBUTE));

}
