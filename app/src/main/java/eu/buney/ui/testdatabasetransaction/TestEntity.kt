package eu.buney.ui.testdatabasetransaction

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author Andrei Buneyeu
 */
@Entity(tableName = "test")
data class TestEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
) : Serializable