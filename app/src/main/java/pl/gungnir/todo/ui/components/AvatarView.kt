package pl.gungnir.todo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.R

@Composable
fun AvatarView(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.avatar),
        contentDescription = "avatar"
    )
}

@Preview
@Composable
fun AvatarViewPreview() {
    AvatarView()
}