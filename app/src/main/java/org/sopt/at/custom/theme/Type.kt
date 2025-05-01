package org.sopt.at.custom.theme

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import org.sopt.at.R

val soptFonts = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.pretendard_regular, FontWeight.Normal, FontStyle.Normal),
)

@Composable
fun BoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    brush: Brush? = null,
    textSize: TextUnit,
    fontStyle: FontStyle? = FontStyle.Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    textStyle: TextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        ),
        brush = brush,
    )
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        fontFamily = soptFonts,
        fontWeight = FontWeight.Bold,
        fontStyle = fontStyle,
        fontSize = textSize,
        letterSpacing = letterSpacing,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    brush: Brush? = null,
    textSize: TextUnit,
    fontStyle: FontStyle? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    textStyle: TextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        ),
        brush = brush,
    )
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        fontFamily = soptFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize,
        color = color,
        textAlign = textAlign,
        fontStyle = fontStyle,
        overflow = overflow,
        maxLines = maxLines,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    brush: Brush? = null,
    textSize: TextUnit,
    fontStyle: FontStyle? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    textStyle: TextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        ),
        brush = brush,
    )
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        fontFamily = soptFonts,
        fontWeight = FontWeight.Medium,
        fontSize = textSize,
        color = color,
        textAlign = textAlign,
        fontStyle = fontStyle,
        overflow = overflow,
        maxLines = maxLines,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun RegularText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    brush: Brush? = null,
    textSize: TextUnit,
    fontStyle: FontStyle? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    textStyle: TextStyle = TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        ),
        brush = brush,
    )
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        fontFamily = soptFonts,
        fontWeight = FontWeight.Normal,
        fontSize = textSize,
        color = color,
        textAlign = textAlign,
        fontStyle = fontStyle,
        overflow = overflow,
        maxLines = maxLines,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}