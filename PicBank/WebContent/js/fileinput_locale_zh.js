/*!
 * FileInput Spanish (Latin American) Translations
 *
 * This file must be loaded after 'fileinput.js'. Patterns in braces '{}', or
 * any HTML markup tags in the messages must not be converted or translated.
 *
 * @see http://github.com/kartik-v/bootstrap-fileinput
 *
 * NOTE: this file must be saved in UTF-8 encoding.
 */
(function ($) {
    "use strict";
    $.fn.fileinput.locales.es = {
    		fileSingle: '单个文件',
            filePlural: '多个文件',
            browseLabel: '选择文件 &hellip;',
            removeLabel: '删除文件',
            removeTitle: '删除选中文件',
            cancelLabel: '取消',
            cancelTitle: '取消上传',
            uploadLabel: '上传',
            uploadTitle: '上传选中文件',
            msgSizeTooLarge: '文件 "{name}" (<b>{size} KB</b>) 超过最大允许上传大小 <b>{maxSize} KB</b>. 请重试您的上传!',
            msgFilesTooLess: '文件数量必须大于 <b>{n}</b> {files} ，请重新上传！',
            msgFilesTooMany: '选择上传的文件数量 <b>({n})</b> 超过最大限度的允许限度 <b>{m}</b>. 请重试您的上传!',
            msgFileNotFound: '文件 "{name}" 未找到!',
            msgFileSecured: '安全限制防止读取文件 "{name}".',
            msgFileNotReadable: '文件: "{name}" 不可读.',
            msgFilePreviewAborted: '文件预览中止 "{name}".',
            msgFilePreviewError: '读取文件时出错 "{name}".',
            msgInvalidFileType: '文件无效类型 "{name}". 只有 "{types}" 文件的支持.',
            msgInvalidFileExtension: '文件扩展名无效 "{name}". 只有 "{extensions}" 文件的支持.',
            msgValidationError: '文件上传错误',
            msgLoading: '加载文件 {index} 在 {files} &hellip;',
            msgProgress: '加载文件 {index} 再 {files} - {name} - {percent}% 完成.',
            msgSelected: '选中{n}个文件',
            msgFoldersNotAllowed: '只能拖放文件! {n} 文件夹将被跳过.',
            dropZoneTitle: '粘贴，拖放，选择图片进行上传!'
    };

    $.extend($.fn.fileinput.defaults, $.fn.fileinput.locales.es);
})(window.jQuery);
