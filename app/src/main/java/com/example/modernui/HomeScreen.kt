package com.example.modernui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BottomMenuContent
import com.example.data.Feature
import com.example.modernui.ui.theme.AquaBlue
import com.example.modernui.ui.theme.Beige1
import com.example.modernui.ui.theme.Beige2
import com.example.modernui.ui.theme.Beige3
import com.example.modernui.ui.theme.BlueViolet1
import com.example.modernui.ui.theme.BlueViolet2
import com.example.modernui.ui.theme.BlueViolet3
import com.example.modernui.ui.theme.ButtonBlue
import com.example.modernui.ui.theme.DarkerButtonBlue
import com.example.modernui.ui.theme.DeepBlue
import com.example.modernui.ui.theme.LightGreen1
import com.example.modernui.ui.theme.LightGreen2
import com.example.modernui.ui.theme.LightGreen3
import com.example.modernui.ui.theme.LightRed
import com.example.modernui.ui.theme.OrangeYellow1
import com.example.modernui.ui.theme.OrangeYellow2
import com.example.modernui.ui.theme.OrangeYellow3
import com.example.modernui.ui.theme.TextWhite
import com.example.standardQuadFromTo


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column() {
            Spacer(modifier = Modifier.height(28.dp))
            AppBarSection()
            Spacer(modifier = Modifier.height(20.dp))
            RowSection(
                list = listOf(
                    "Sweet sleep",
                    "Insomnia",
                    "Depression",
                    "Insomnia",
                    "Depression ",
                    "Sweet sleep"
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardMeditation()
            Spacer(modifier = Modifier.height(8.dp))
            Features(
                featureList = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.baseline_headphones_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.baseline_headphones_24,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.baseline_headphones_24,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.baseline_headphones_24,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.baseline_home_24),
                BottomMenuContent("Meditate", R.drawable.baseline_bubble_chart_24),
                BottomMenuContent("Sleep", R.drawable.baseline_brightness_3_24),
                BottomMenuContent("Music", R.drawable.baseline_music_note_24),
                BottomMenuContent("Profile", R.drawable.baseline_person_24),
            ), modifier = Modifier.align(Alignment.BottomCenter))



    }

}

@Composable
fun AppBarSection() {

    //top app bar
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // inner app bar
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good morning, Mohamed",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 20.sp


            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                fontSize = 15.sp
            )


        }

        Icon(
            painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun RowSection(list: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(list.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = list[it], color = TextWhite)
            }
        }
    }

}


@Composable
fun CardMeditation (color: Color = LightRed){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 28.sp,
                    color = Color.White
                )
                Text(
                    text = "Meditation • 3-10 min",
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }

    }
}



@Composable
fun  Features(featureList:List<Feature>){
    
    Column (modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(featureList.size) {
                FeatureItem(feature = featureList[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)

            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style =MaterialTheme.typography.bodySmall,
                fontSize = 18.sp,
                color = Color.White,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

