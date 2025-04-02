package dev.zero.jetpackdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class SuggestionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookCategorySelectionScreen()
        }
    }
}

@Composable
fun BookCategorySelectionScreen() {
    val categories = listOf(
        "Fiction", "Mystery", "Science Fiction", "Fantasy",
        "Adventure", "Historical", "Horror", "Romance"
    )

    val suggestions = listOf("Biography", "Cookbook", "Poetry", "Self-help", "Thriller")

    var selectedCategories by remember { mutableStateOf(setOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFECEFF1)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // AssistChip (Hướng dẫn / Clear selections)
        if (selectedCategories.isEmpty()) {
            AssistChip(
                onClick = { /* Hướng dẫn */ },
                label = { Text("Need help?") }
            )
        } else {
            AssistChip(
                onClick = { selectedCategories = emptySet() },
                label = { Text("Clear selections") }
            )
        }

        // Danh sách thể loại chính (FilterChip)
        Text("Choose categories:")
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategories.contains(category),
                    onClick = {
                        selectedCategories = if (selectedCategories.contains(category)) {
                            selectedCategories - category
                        } else {
                            selectedCategories + category
                        }
                    },
                    label = { Text(category) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        // Danh sách gợi ý (SuggestionChip)
        Text("Suggestions:")
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            suggestions.forEach { suggestion ->
                SuggestionChip(
                    onClick = { selectedCategories = selectedCategories + suggestion },
                    label = { Text(suggestion) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        // Hiển thị thể loại đã chọn (InputChip)
        if (selectedCategories.isNotEmpty()) {
            Text("Selected categories:")
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                selectedCategories.forEach { category ->
                    InputChip(
                        selected = true,
                        onClick = { },
                        label = { Text(category) },
                        trailingIcon = {
                            IconButton(onClick = { selectedCategories -= category }) {
                                Icon(Icons.Default.Close, contentDescription = "Remove")
                            }
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
    }
}
