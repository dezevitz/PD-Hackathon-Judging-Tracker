package com.example.hackathonjudgingtracker.data.domain

import java.util.UUID

data class Hackathon(
    val id: UUID,
    val projectIds: List<ProjectId>,
    val judgeIds: List<JudgeId>,
    val judgingTime: Hour
)

@JvmInline
value class Hour(val value: Int)

@JvmInline
value class ProjectId(val value: UUID)

@JvmInline
value class JudgeId(val value: UUID)
